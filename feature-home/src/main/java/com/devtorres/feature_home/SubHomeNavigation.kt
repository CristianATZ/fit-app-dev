package com.devtorres.feature_home

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen

fun NavGraphBuilder.subHomeScreen(
    drawerState: DrawerState,
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit
) {
    composable(Screen.HomeSub.route) {
        SubHomeScreen(
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement
        )
    }
}