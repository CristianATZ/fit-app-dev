package com.devtorres.feature_routines.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_routines.RoutinesScreen

const val routinesRoute = "routines"

fun NavGraphBuilder.routinesScreen(
    drawerState: DrawerState,
    onNavigateToRoutine: () -> Unit,
) {
    composable(route = routinesRoute) {
        // inicializar viewmodel aqui
        RoutinesScreen(
            drawerState = drawerState,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}