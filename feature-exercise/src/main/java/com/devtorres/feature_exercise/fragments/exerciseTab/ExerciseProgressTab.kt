package com.devtorres.feature_exercise.fragments.exerciseTab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.core_utils.Extensions.toAbosulte
import com.devtorres.core_utils.StringUtils
import com.devtorres.core_utils.StringUtils.setColorToPercentage
import com.devtorres.feature_exercise.ExerciseProgressViewModel
import com.devtorres.feature_exercise.R
import com.devtorres.feature_exercise.components.InformationCard
import com.devtorres.feature_exercise.fragments.progressTab.ProgressAddSerieTab
import com.devtorres.feature_exercise.fragments.progressTab.ProgressChartTab
import com.devtorres.feature_exercise.fragments.progressTab.ProgressHistoricalTab
import com.devtorres.ui_common.tab.CustomTabRow
import com.devtorres.ui_common.typo.TitleMedium
import kotlinx.coroutines.launch

@Composable
fun ExerciseProgressTab(
    progressViewModel: ExerciseProgressViewModel,
    exerciseName: String
) {
    val progressList by progressViewModel.progressList.collectAsStateWithLifecycle()
    val totalProgressCount by progressViewModel.totalProgressCount.collectAsStateWithLifecycle()

    val isLoading by progressViewModel::isLoading
    val toastMessage by progressViewModel::toastMessage

    val tabList = remember {
        listOf(
            R.string.tab_add_serie,
            R.string.tab_chart,
            R.string.tab_historical
        )
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabList.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.animateContentSize()
    ) {
        if(isLoading) {
            CircularProgressIndicator(
                color = colorScheme.secondary
            )
        } else {
            ProgressCards(
                progressList = progressList,
                totalProgressCount = totalProgressCount
            )
        }

        CustomTabRow (
            tabList = tabList,
            selectedTabIndex = pagerState.currentPage,
            onSelectedTab = { tabIndex ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(tabIndex)
                }
            },
            modifier = Modifier.padding(bottom = 32.dp, top = 24.dp)
        )

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            verticalAlignment = Alignment.Top
        ) { page ->
            when(page) {
                0 -> {
                    ProgressAddSerieTab(
                        exerciseName = exerciseName,
                        exerciseProgressViewModel = progressViewModel
                    )
                }
                1 -> {
                    ProgressChartTab(
                        exerciseName = exerciseName
                    )
                }
                2 -> {
                    ProgressHistoricalTab(
                        exerciseName = exerciseName
                    )
                }
            }
        }
    }
}

@Composable
fun NoProgressHistory() {
    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium,
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleMedium(
            stringResId = R.string.lblNoProgressHistory,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun ProgressCards(
    progressList: List<ProgressSummary>,
    totalProgressCount: Int
) {

    /**
     * HACER UN CASO DE USO PARA CADA COSA:
     *
     * 2. PARA OBTENER EL MAXIMO DE ROOM
     * 3. PARA OBTENER LOS ULTIMOS DOS
     *
     * 4. UN FLOW QUE OBSERVER LA DB Y ACTUALICE LA LISTA
     */
    val oneRm = progressList.lastOrNull()?.calculateOneRM()

    val differencePercent = if (progressList.size >= 2) {
        StringUtils.calculateDifeferencePercent(
            lastestExercise = progressList[progressList.size - 1],
            previousExercise = progressList[progressList.size - 2]
        )
    } else null

    val differenceColor = setColorToPercentage(differencePercent)

    if(progressList.isEmpty()) {
        NoProgressHistory()
    } else {
        AnimatedVisibility(totalProgressCount != 0) {
            Column {
                InformationCard(
                    titleResId = R.string.lblTotalSeriesUpperCase,
                    description = stringResource(R.string.lblTotalSeriesDescription),
                    text = totalProgressCount.toString(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.size(12.dp))
            }
        }

        AnimatedVisibility(progressList.isNotEmpty()) {
            Column {
                InformationCard(
                    titleResId = R.string.lblRmEstimatedUpperCase,
                    description = stringResource(
                        R.string.lblRmEstimatedDescription,
                        progressList.last().getWeightFormatted(),
                        progressList.last().reps.toString()
                    ),
                    text = stringResource(R.string.kg_count, oneRm!!),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.size(12.dp))
            }
        }

        AnimatedVisibility(differencePercent != null) {
            Column {
                InformationCard(
                    titleResId = R.string.lblRecentlyProgressUpperCase,
                    description = stringResource(R.string.lblRecentlyProgressDescription),
                    text = stringResource(R.string.percentage_count, differencePercent!!.toAbosulte()),
                    color = differenceColor,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
