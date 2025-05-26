package com.devtorres.feature_exercise

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.dto.BreadcrumbItem
import com.devtorres.finager.core.presentation.components.typo.BodySmall

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseScreen(
    onNavigateBack: () -> Unit,
    exerciseDetailViewModel: ExerciseDetailViewModel
) {
    val breadcrumbs by exerciseDetailViewModel.breadcrumbs.collectAsStateWithLifecycle()
    val exerciseId by exerciseDetailViewModel.exerciseId.collectAsStateWithLifecycle()
    val isLoading by exerciseDetailViewModel.isLoading.collectAsStateWithLifecycle()

    BackHandler {
        if(breadcrumbs.size > 1) {
            exerciseDetailViewModel.changeExercise(breadcrumbs.toList()[breadcrumbs.toList().lastIndex - 1].id)
        } else {
            exerciseDetailViewModel.clearBreadcrumbs()
            onNavigateBack()
        }
    }

    Scaffold {  innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                    BradcrumbCard(
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

            if(isLoading) {
                CircularProgressIndicator(
                    color = colorScheme.secondary
                )
            } else {
                Button(
                    onClick = {
                        exerciseDetailViewModel.changeExercise("Barbell_Squat")
                    }
                ) {
                    Text(text = "Variant")
                }

                Button(
                    onClick = {
                        exerciseDetailViewModel.changeExercise("Barbell_Bench_Press")
                    }
                ) {
                    Text(text = "Variant")
                }

                Button(
                    onClick = {
                        exerciseDetailViewModel.changeExercise("asdasd")
                    }
                ) {
                    Text(text = "Variant")
                }

                Button(
                    onClick = {
                        exerciseDetailViewModel.changeExercise("oskok")
                    }
                ) {
                    Text(text = "Variant")
                }
            }
        }
    }
}

@Composable
fun BradcrumbCard(
    modifier: Modifier,
    exerciseId: String,
    breadcrumb: BreadcrumbItem,
    onClickItem: () -> Unit,
    isLoading: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InputChip(
            selected = exerciseId == breadcrumb.id,
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = colorScheme.secondary,
                selectedLabelColor = colorScheme.onSecondary,
                containerColor = colorScheme.outline
            ),
            onClick = onClickItem,
            enabled = !isLoading,
            label = {
                BodySmall(
                    text = breadcrumb.name,
                    modifier = Modifier
                        .alpha(
                            if (exerciseId == breadcrumb.id) 1f else 0.5f
                        )
                )
            }
        )

        Spacer(Modifier.size(8.dp))
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .alpha(0.5f)
        )
        Spacer(Modifier.size(8.dp))
    }
}
