package com.devtorres.feature_home.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_home.HomeScreen

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    composable(route = homeRoute) {
        HomeScreen(
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}