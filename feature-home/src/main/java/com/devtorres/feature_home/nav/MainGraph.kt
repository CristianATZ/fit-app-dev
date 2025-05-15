package com.devtorres.feature_home.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devtorres.core_navigation.Screen
import com.devtorres.core_navigation.controller.navigateToExercise
import com.devtorres.core_navigation.controller.navigateToRoutine
import com.devtorres.core_navigation.controller.navigateToSupplement
import com.devtorres.feature_exercise.nav.exerciseScreen
import com.devtorres.feature_home.homeRootScreen
import com.devtorres.feature_routines.nav.routineScreen
import com.devtorres.feature_supplements.nav.supplementScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeRoot.route
    ) {
        homeRootScreen(
            onNavigateToExercise = {
                navController.navigateToExercise("fakeExercise")
            },
            onNavigateToSupplement = {
                navController.navigateToSupplement("fakeSupplement")
            },
            onNavigateToRoutine = {
                navController.navigateToRoutine("fakeRoutine")
            }
        )

        exerciseScreen {
            navController.navigateUp()
        }

        supplementScreen {
            navController.navigateUp()
        }

        routineScreen {
            navController.navigateUp()
        }
    }
}