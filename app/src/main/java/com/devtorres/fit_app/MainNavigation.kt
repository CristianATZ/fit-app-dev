package com.devtorres.fit_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devtorres.feature_exercises.nav.exerciseScreen
import com.devtorres.feature_exercises.nav.exercisesScreen
import com.devtorres.feature_exercises.nav.navigateToExercise
import com.devtorres.feature_home.nav.homeRoute
import com.devtorres.feature_home.nav.homeScreen
import com.devtorres.feature_routines.nav.navigateToRoutine
import com.devtorres.feature_routines.nav.routineScreen
import com.devtorres.feature_supplements.nav.navigateToSupplement
import com.devtorres.feature_supplements.nav.supplementScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = homeRoute
    ) {
        homeScreen(
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