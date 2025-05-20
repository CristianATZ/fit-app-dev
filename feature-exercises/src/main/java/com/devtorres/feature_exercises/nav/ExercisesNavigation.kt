package com.devtorres.feature_exercises.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercises.ExercisesScreen
import com.devtorres.feature_exercises.ExercisesViewModel

fun NavGraphBuilder.exercisesScreen(
    innerPadding: PaddingValues,
    onNavigateToExercise: () -> Unit
) {
    composable(Screen.Exercises.route) {
        // iniciailizar viewmodel aqui con hilt
        val exercisesViewModel = hiltViewModel<ExercisesViewModel>()

        ExercisesScreen(
            exercisesViewModel = exercisesViewModel,
            innerPadding = innerPadding,
            onNavigateToExercise = onNavigateToExercise
        )
    }
}