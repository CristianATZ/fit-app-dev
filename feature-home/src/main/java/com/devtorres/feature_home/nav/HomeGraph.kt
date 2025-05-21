package com.devtorres.feature_home.nav

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
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
import com.devtorres.feature_home.components.CustomTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun HomeNavigation(
    navController: NavHostController,
    startDestination: String = Screen.HomeSub.route,
    drawerState: DrawerState,
    onNavigateToExercise: (String) -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                drawerState = drawerState
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            subHomeScreen(
                innerPadding = innerPadding,
                drawerState = drawerState,
                onNavigateToExercises = { navController.navigateToExercises() },
                onNavigateToSupplements = { navController.navigateToSupplements() },
                onNavigateToRoutines = { navController.navigateToRoutines() }
            )

            exercisesScreen(
                innerPadding = innerPadding,
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
}