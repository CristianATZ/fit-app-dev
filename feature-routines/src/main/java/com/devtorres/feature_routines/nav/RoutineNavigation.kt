package com.devtorres.feature_routines.nav

import androidx.compose.material3.DrawerState
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_routines.RoutineScreen
import com.devtorres.feature_routines.RoutinesScreen

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

fun NavGraphBuilder.routinesScreen(
    drawerState: DrawerState,
    onNavigateToRoutine: () -> Unit,
) {
    composable(Screen.Routines.route) {
        // inicializar viewmodel aqui
        RoutinesScreen(
            drawerState = drawerState,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}