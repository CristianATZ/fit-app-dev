package com.devtorres.feature_routine.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_routine.RoutineScreen

private const val routineIdArg = "routineId"

internal class RoutineArgs(routineId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(checkNotNull(savedStateHandle[routineIdArg]) as String)
}

fun NavGraphBuilder.routineScreen(
    onNavigateBack: () -> Unit
) {
    composable(Screen.Routine.route) {
        // inicializar viewmodel aqui
        RoutineScreen(
            onNavigateBack = onNavigateBack
        )
    }
}