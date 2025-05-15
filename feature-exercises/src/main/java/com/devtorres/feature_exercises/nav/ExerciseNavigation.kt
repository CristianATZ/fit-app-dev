package com.devtorres.feature_exercises.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_exercises.ExerciseScreen

private const val exerciseIdArg = "exerciseId"

internal sealed class ExerciseScreen(val route: String) {
    data object Detail : ExerciseScreen("exercise/{$exerciseIdArg}") {
        fun createRoute(id: String) = "exercise/$id"
    }
}

fun NavGraphBuilder.exerciseScreen(
    onNavigateBack: () -> Unit
) {
    composable(ExerciseScreen.Detail.route) {
        // inicializar viewmodel aqui
        ExerciseScreen(
            onNavigateBack = onNavigateBack
        )
    }
}

fun NavController.navigateToExercise(exerciseId: String) {
    this.navigate(ExerciseScreen.Detail.createRoute(exerciseId))
}

internal class ExerciseArgs(exerciseId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(checkNotNull(savedStateHandle[exerciseIdArg]) as String)
}
