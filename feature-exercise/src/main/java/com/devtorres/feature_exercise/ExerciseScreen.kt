package com.devtorres.feature_exercise

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.ui.EquipmentDetail
import com.devtorres.core_model.ui.ExerciseDetail
import com.devtorres.feature_exercise.fragments.ExerciseDescriptionFragment
import com.devtorres.feature_exercise.fragments.ExerciseImagesFragment
import com.devtorres.feature_exercise.fragments.ExerciseInstructionsFragment
import com.devtorres.ui_common.BreadcrumbCard
import com.devtorres.ui_common.CustomScrollableTab
import com.devtorres.ui_common.ImageTitleCard
import com.devtorres.ui_common.badge.LevelBadge
import com.devtorres.ui_common.badge.SurfaceBadge
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.image.AsyncImageLoader
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.typo.HeadLineSmall
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.launch

@Composable
fun ExerciseScreen(
    onNavigateBack: () -> Unit,
    exerciseDetailViewModel: ExerciseDetailViewModel
) {
    val breadcrumbs by exerciseDetailViewModel.breadcrumbs.collectAsStateWithLifecycle()
    val exerciseId by exerciseDetailViewModel.exerciseId.collectAsStateWithLifecycle()
    val exerciseDetail by exerciseDetailViewModel.exerciseDetail.collectAsStateWithLifecycle()
    val isLoading by exerciseDetailViewModel.isLoading.collectAsStateWithLifecycle()

    BackHandler {
        if(breadcrumbs.size > 1) {
            exerciseDetailViewModel.changeExercise(breadcrumbs.toList()[breadcrumbs.toList().lastIndex - 1].id)
        } else {
            if(!isLoading) {
                exerciseDetailViewModel.clearBreadcrumbs()
                onNavigateBack()
            }
        }
    }

    Scaffold {  innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            LazyRow(
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(
                    items = breadcrumbs.toList(),
                    key = { _, breadcrumb -> breadcrumb.id }
                ) { index, breadcrumb ->
                    BreadcrumbCard(
                        exerciseId = exerciseId,
                        breadcrumb = breadcrumb,
                        onClickItem = {
                            exerciseDetailViewModel.changeExercise(breadcrumb.id)
                        },
                        isLoading = isLoading,
                        modifier = Modifier.animateItem(
                            fadeInSpec = tween(durationMillis = 300),
                            fadeOutSpec = tween(durationMillis = 300)
                        )
                    )

                    if(isLoading && index == breadcrumbs.toList().lastIndex) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            color = colorScheme.secondary
                        )
                    }
                }
            }

            Spacer(Modifier.size(24.dp))

            if(isLoading) {
                CircularProgressIndicator(
                    color = colorScheme.secondary
                )
            } else {
                exerciseDetail?.let { exercise ->
                    // header
                    ExerciseHeader(
                        exercise = exercise
                    )

                    Spacer(Modifier.size(16.dp))

                    // information badges
                    ExerciseBasicInformation(
                        level = exercise.level,
                        equipment = exercise.equipment,
                        mechanic = exercise.mechanic,
                        force = exercise.force,
                        category = exercise.category
                    )

                    ExerciseContent(
                        exerciseDetailViewModel = exerciseDetailViewModel,
                        exercise = exercise
                    )
                }
            }
        }
    }
}

@Composable
private fun ExerciseContent(
    exerciseDetailViewModel: ExerciseDetailViewModel,
    exercise: ExerciseDetail
) {
    val tabList = remember {
        listOf(
            R.string.tab_description,
            R.string.tab_instructions,
            R.string.tab_images,
            R.string.tab_equipment,
            R.string.tab_progress
        )
    }

    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabList.size }
    )

    // tabrow
    CustomScrollableTab(
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
        verticalAlignment = Alignment.Top
    ) { page ->
        when (page) {
            0 -> {
                ExerciseDescriptionFragment(
                    details = exercise,
                    navigateToExerciseVariant = { exerciseVariantId ->
                        exerciseDetailViewModel.changeExercise(exerciseVariantId)
                    }
                )
            }
            1 -> {
                ExerciseInstructionsFragment(
                    instructions = exercise.instructions
                )
            }
            2 -> {
                ExerciseImagesFragment(
                    imageUris = exercise.getImagesUri()
                )
            }
            3 -> {
                ExerciseEquiptmentFragment(
                    equipments = exercise.equipments
                )
            }
            4 -> {
                ProgressFragment(

                )
            }
        }
    }
}

@Composable
fun ExerciseEquiptmentFragment(
    equipments: List<EquipmentDetail>
) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
    ) {
        equipments.forEach { equipment ->
            Log.d("imageURi", equipment.getPreviewImageUri())
            ImageTitleCard(
                folderPath = equipment.getPreviewImageUri(),
                title = equipment.name,
                onClick = {
                    // abrir dialogo

                }
            )
        }
    }
}

@Composable
fun ProgressFragment() {
    Text(
        text = "progress"
    )
}

@Composable
private fun ExerciseHeader(
    exercise: ExerciseDetail
) {
    Row {
        HeadLineSmall(
            text = exercise.name.uppercase(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(0.6f)
        )

        Spacer(Modifier.size(12.dp))

        CustomOutlinedButton(
            stringResId = R.string.btnShare,
            onClick = {

            },
            modifier = Modifier.weight(0.4f)
        )
    }
}

@Composable
private fun ExerciseBasicInformation(
    level: LevelType,
    equipment: EquipmentType,
    mechanic: MechanicType,
    force: ForceType,
    category: ExerciseCategory
) {
    FlowRow (
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        LevelBadge(
            level = level
        )

        SurfaceBadge(
            label = stringResource(equipment.stringRes())
        )

        SurfaceBadge(
            label = stringResource(mechanic.stringRes())
        )

        SurfaceBadge(
            label = stringResource(force.stringRes())
        )

        SurfaceBadge(
            label = stringResource(category.stringRes())
        )
    }
}
