package com.devtorres.feature_home

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devtorres.feature_exercises.nav.exercisesScreen
import com.devtorres.feature_home.nav.homeRoute
import com.devtorres.feature_home.nav.subHomeRoute
import com.devtorres.feature_home.nav.subHomeScreen
import com.devtorres.feature_routines.nav.routinesScreen
import com.devtorres.feature_supplements.nav.supplementsScreen
import kotlinx.coroutines.CoroutineScope

@Composable
internal fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit,
    onNavigateToRoutine: () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

        }
    ) {
        NavHost(
            navController = navController,
            startDestination = subHomeRoute
        ) {
            subHomeScreen(
                drawerState = drawerState,
                onNavigateToExercise = onNavigateToExercise,
                onNavigateToSupplement = onNavigateToSupplement
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
}