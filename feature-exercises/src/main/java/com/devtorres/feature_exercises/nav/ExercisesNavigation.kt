package com.devtorres.feature_exercises.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercises.ExercisesScreen

fun NavGraphBuilder.exercisesScreen(
    drawerState: DrawerState,
    onNavigateToExercise: () -> Unit
) {
    composable(Screen.Exercises.route) {
        // iniciailizar viewmodel aqui con hilt
        ExercisesScreen(
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise
        )
    }
}