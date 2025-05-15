package com.devtorres.feature_exercise.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercise.ExerciseScreen

private const val exerciseIdArg = "exerciseId"

internal class ExerciseArgs(exerciseId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(checkNotNull(savedStateHandle[exerciseIdArg]) as String)
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