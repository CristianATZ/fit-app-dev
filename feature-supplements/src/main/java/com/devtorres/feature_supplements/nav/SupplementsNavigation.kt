package com.devtorres.feature_supplements.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_supplements.SupplementsScreen

fun NavGraphBuilder.supplementsScreen(
    drawerState: DrawerState,
    onNavigateToSupplement: () -> Unit
) {
    composable(Screen.Supplements.route) {
        // iniciailizar viewmodel aqui con hilt
        SupplementsScreen(
            drawerState = drawerState,
            onNavigateToSupplement = onNavigateToSupplement
        )
    }
}