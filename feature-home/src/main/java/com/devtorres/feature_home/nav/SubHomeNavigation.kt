package com.devtorres.feature_home.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_home.SubHomeScreen

const val subHomeRoute = "subHome"

fun NavGraphBuilder.subHomeScreen(
    drawerState: DrawerState,
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit
) {
    composable(route = "subHome") {
        SubHomeScreen(
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement
        )
    }
}