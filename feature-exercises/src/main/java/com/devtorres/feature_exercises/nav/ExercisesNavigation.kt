package com.devtorres.feature_exercises.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_exercises.ExercisesScreen

const val exercisesRoute = "exercises"

fun NavGraphBuilder.exercisesScreen(
    drawerState: DrawerState,
    onNavigateToExercise: () -> Unit
) {
    composable(route = exercisesRoute) {
        // iniciailizar viewmodel aqui con hilt
        ExercisesScreen(
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise
        )
    }
}