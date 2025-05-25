package com.devtorres.feature_exercise.nav

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_exercise.ExerciseScreen
import com.devtorres.feature_exercise.ExerciseDetailViewModel

private const val exerciseIdArg = "exerciseId"

internal class ExerciseArgs(val exerciseId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                checkNotNull(
                    savedStateHandle[exerciseIdArg]
                ) { "El argumento '$exerciseIdArg' es nulo o no fue pasado" } as String
            ) { require(exerciseId.isNotEmpty()) { "exerciseId no puede estar vacío" } }
}

fun NavGraphBuilder.exerciseScreen(
    onNavigateBack: () -> Unit
) {
    composable(
        route = Screen.Exercise.route,
        arguments = listOf(
            navArgument(exerciseIdArg) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        // inicializar viewmodel aqui
        val exerciseDetailViewModel: ExerciseDetailViewModel = hiltViewModel(backStackEntry)
        ExerciseScreen(
            exerciseDetailViewModel = exerciseDetailViewModel,
            onNavigateBack = onNavigateBack
        )
    }
}