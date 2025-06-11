package com.devtorres.feature_exercise.fragments.exerciseTab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.feature_exercise.ExerciseProgressViewModel
import com.devtorres.feature_exercise.R
import com.devtorres.feature_exercise.components.InformationCard
import com.devtorres.feature_exercise.fragments.progressTab.ProgressAddSerieTab
import com.devtorres.feature_exercise.fragments.progressTab.ProgressChartTab
import com.devtorres.feature_exercise.fragments.progressTab.ProgressHistoricalTab
import com.devtorres.ui_common.tab.CustomTabRow
import kotlinx.coroutines.launch

@Composable
fun ExerciseProgressTab(
    exerciseProgressViewModel: ExerciseProgressViewModel = hiltViewModel(),
    exerciseName: String
) {
    val progressList by exerciseProgressViewModel.progressList.collectAsStateWithLifecycle()

    val isLoading by exerciseProgressViewModel::isLoading
    val toastMessage by exerciseProgressViewModel::toastMessage

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

    if(isLoading) {
        CircularProgressIndicator(
            color = colorScheme.secondary
        )
    } else {
        Column {
            Row {
                InformationCard(
                    titleResId = R.string.lblTotalSeriesUpperCase,
                    description = stringResource(R.string.lblTotalSeriesDescription),
                    text = "0",
                    modifier = Modifier.weight(0.5f)
                )

                Spacer(Modifier.size(12.dp))

                InformationCard(
                    titleResId = R.string.lblRmEstimatedUpperCase,
                    description = stringResource(R.string.lblRmEstimatedDescription, 1, 1),
                    text = "0 kg",
                    modifier = Modifier.weight(0.5f)
                )
            }

            Spacer(Modifier.size(12.dp))

            InformationCard(
                titleResId = R.string.lblRecentlyProgressUpperCase,
                description = stringResource(R.string.lblRecentlyProgressDescription),
                text = "0%",
                modifier = Modifier.fillMaxWidth()
            )

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
                            exerciseProgressViewModel = exerciseProgressViewModel
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
}