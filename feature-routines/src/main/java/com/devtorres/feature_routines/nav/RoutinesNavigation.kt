package com.devtorres.feature_routines.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_routines.RoutinesScreen

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