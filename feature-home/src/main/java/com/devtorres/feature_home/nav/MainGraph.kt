package com.devtorres.feature_home.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devtorres.core_navigation.Screen
import com.devtorres.core_navigation.controller.navigateToExercise
import com.devtorres.core_navigation.controller.navigateToExercises
import com.devtorres.core_navigation.controller.navigateToRoutine
import com.devtorres.core_navigation.controller.navigateToSupplement
import com.devtorres.feature_exercise.nav.exerciseScreen
import com.devtorres.feature_home.homeRootScreen
import com.devtorres.feature_routine.nav.routineScreen
import com.devtorres.feature_supplement.nav.supplementScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeRoot.route
    ) {
        homeRootScreen(
            onNavigateToExercise = { id ->
                navController.navigateToExercise(exerciseId = id)
            },
            onNavigateToSupplement = {
                navController.navigateToSupplement("fakeSupplement")
            },
            onNavigateToRoutine = {
                navController.navigateToRoutine("fakeRoutine")
            }
        )

        exerciseScreen(
            onNavigateBack = {
                navController.navigateUp()
            }
        )

        supplementScreen {
            navController.navigateUp()
        }

        routineScreen {
            navController.navigateUp()
        }
    }
}