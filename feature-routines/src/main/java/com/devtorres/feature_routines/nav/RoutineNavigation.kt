package com.devtorres.feature_routines.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_routines.RoutineScreen

private const val routineIdArg = "routineId"

internal sealed class RoutineScreen(val route: String) {
    data object Detail : RoutineScreen("routine/{$routineIdArg}") {
        fun createRoute(id: String) = "routine/$id"
    }
}

fun NavGraphBuilder.routineScreen(
    onNavigateBack: () -> Unit
) {
    composable(RoutineScreen.Detail.route) {
        // inicializar viewmodel aqui
        RoutineScreen(
            onNavigateBack = onNavigateBack
        )
    }
}

fun NavController.navigateToRoutine(routineId: String) {
    this.navigate(RoutineScreen.Detail.createRoute(routineId))
}

internal class RoutineArgs(routineId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(checkNotNull(savedStateHandle[routineIdArg]) as String)
}