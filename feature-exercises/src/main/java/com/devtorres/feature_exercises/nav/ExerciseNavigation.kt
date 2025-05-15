package com.devtorres.feature_exercises.nav

import androidx.compose.material3.DrawerState
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercises.ExerciseScreen
import com.devtorres.feature_exercises.ExercisesScreen

private const val exerciseIdArg = "exerciseId"

internal class ExerciseArgs(exerciseId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(checkNotNull(savedStateHandle[exerciseIdArg]) as String)
}

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

fun NavGraphBuilder.exerciseScreen(
    onNavigateBack: () -> Unit
) {
    composable(Screen.Exercise.route) {
        // inicializar viewmodel aqui
        ExerciseScreen(
            onNavigateBack = onNavigateBack
        )
    }
}