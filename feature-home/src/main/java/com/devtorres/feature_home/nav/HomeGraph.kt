package com.devtorres.feature_home.nav

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.devtorres.core_navigation.Screen
import com.devtorres.core_navigation.controller.navigateToExercises
import com.devtorres.core_navigation.controller.navigateToRoutines
import com.devtorres.core_navigation.controller.navigateToSupplements
import com.devtorres.feature_exercises.nav.exercisesScreen
import com.devtorres.feature_home.subHomeScreen
import com.devtorres.feature_routines.nav.routinesScreen
import com.devtorres.feature_supplements.nav.supplementsScreen

@Composable
fun HomeNavigation(
    navController: NavHostController,
    startDestination: String = Screen.HomeSub.route,
    drawerState: DrawerState,
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        subHomeScreen(
            drawerState = drawerState,
            onNavigateToExercises = { navController.navigateToExercises() },
            onNavigateToSupplements = { navController.navigateToSupplements() },
            onNavigateToRoutines = { navController.navigateToRoutines() }
        )

        exercisesScreen(
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise
        )

        supplementsScreen(
            drawerState = drawerState,
            onNavigateToSupplement = onNavigateToSupplement
        )

        routinesScreen(
            drawerState = drawerState,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}