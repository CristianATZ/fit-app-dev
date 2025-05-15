package com.devtorres.feature_supplements.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_supplements.SupplementsScreen

const val supplementsRoute = "supplements"

fun NavGraphBuilder.supplementsScreen(
    drawerState: DrawerState,
    onNavigateToSupplement: () -> Unit
) {
    composable(route = supplementsRoute) {
        // iniciailizar viewmodel aqui con hilt
        SupplementsScreen(
            drawerState = drawerState,
            onNavigateToSupplement = onNavigateToSupplement
        )
    }
}