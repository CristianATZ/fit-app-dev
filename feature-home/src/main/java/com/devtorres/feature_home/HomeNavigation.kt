package com.devtorres.feature_home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen

internal fun NavGraphBuilder.homeRootScreen(
    onNavigateToExercise: (String) -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    composable(Screen.HomeRoot.route) {
        HomeScreen(
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}