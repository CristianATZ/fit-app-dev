package com.devtorres.feature_home

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devtorres.feature_home.nav.HomeNavigation
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
        HomeNavigation(
            navController = navController,
            drawerState = drawerState,
            onNavigateToExercise = onNavigateToExercise,
            onNavigateToSupplement = onNavigateToSupplement,
            onNavigateToRoutine = onNavigateToRoutine
        )
    }
}