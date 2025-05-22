package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.ui_common.ExerciseCard
import com.devtorres.feature_exercises.fragments.ExercisesHeaderFragment

@Composable
fun ExercisesScreen(
    exercisesViewModel: ExercisesViewModel,
    innerPadding: PaddingValues,
    onNavigateToExercise: (String) -> Unit
) {
    val exercises by exercisesViewModel.exerciseList.collectAsStateWithLifecycle()
    val isLoading by exercisesViewModel.isLoading.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(innerPadding)
            .padding(24.dp)
    ) {
        item {
            ExercisesHeaderFragment()
        }

        if(isLoading) {
            item {
                CircularProgressIndicator(
                    color = colorScheme.secondary
                )
            }
        } else {
            itemsIndexed(
                items = exercises,
                key = {
                    _, exercise -> exercise.id
                }
            ) { index, exercise ->
                ExerciseCard(
                    exercise = exercise,
                    onNavigateToExercise = {
                        onNavigateToExercise(exercise.id)
                    }
                )

                if(index < exercises.lastIndex) {
                    Spacer(Modifier.size(16.dp))
                }
            }
        }
    }
}