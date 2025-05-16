package com.devtorres.feature_home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.subHomeScreen(
    drawerState: DrawerState,
    onNavigateToExercises: () -> Unit,
    onNavigateToSupplements: () -> Unit,
    onNavigateToRoutines: () -> Unit,
    innerPadding: PaddingValues
) {
    composable(Screen.HomeSub.route) {
        SubHomeScreen(
            drawerState = drawerState,
            innerPadding = innerPadding,
            onNavigateToExercises = onNavigateToExercises,
            onNavigateToSupplements = onNavigateToSupplements,
            onNavigateToRoutines = onNavigateToRoutines
        )
    }
}