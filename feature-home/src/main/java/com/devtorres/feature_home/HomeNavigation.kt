package com.devtorres.feature_home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen

fun NavGraphBuilder.homeRootScreen(
    onNavigateToExercise: () -> Unit,
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