package com.devtorres.feature_exercises.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercises.ExercisesScreen

fun NavGraphBuilder.exercisesScreen(
    innerPadding: PaddingValues,
    onNavigateToExercise: () -> Unit
) {
    composable(Screen.Exercises.route) {
        // iniciailizar viewmodel aqui con hilt
        ExercisesScreen(
            innerPadding = innerPadding,
            onNavigateToExercise = onNavigateToExercise
        )
    }
}