package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.feature_exercises.components.EmptyExercisesList
import com.devtorres.feature_exercises.components.ExercisesListShimmerEffect
import com.devtorres.feature_exercises.fragments.ExercisesHeaderFragment
import com.devtorres.ui_common.ExerciseCard
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ExercisesScreen(
    exercisesViewModel: ExercisesViewModel,
    innerPadding: PaddingValues,
    onNavigateToExercise: (String) -> Unit
) {
    val exercises by exercisesViewModel.filteredExercises.collectAsStateWithLifecycle()
    val isLoading by exercisesViewModel.isLoading.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(innerPadding)
            .padding(24.dp)
    ) {
        item {
            ExercisesHeaderFragment(
                exercisesViewModel = exercisesViewModel
            )
        }

        // Loading Indicator
        if (isLoading) {
            item {
                ExercisesListShimmerEffect()
            }
            return@LazyColumn
        }

        // Empty State
        if (exercises.isEmpty()) {
            item {
                EmptyExercisesList()
            }
            return@LazyColumn
        }

        // Exercise Count Label
        item {
            LabelLarge(
                text = stringResource(R.string.lblMuscleCount, exercises.size),
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(bottom = 8.dp)
            )
        }

        // Exercise List
        itemsIndexed(
            items = exercises,
            key = { _, exercise -> exercise.id }
        ) { index, exercise ->
            ExerciseCard(
                exercise = exercise,
                onNavigateToExercise = { onNavigateToExercise(exercise.id) }
            )

            if (index < exercises.lastIndex) {
                Spacer(Modifier.size(16.dp))
            }
        }
    }
}