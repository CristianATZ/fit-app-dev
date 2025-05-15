package com.devtorres.feature_supplements.nav

import androidx.compose.material3.DrawerState
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_supplements.SupplementScreen
import com.devtorres.feature_supplements.SupplementsScreen

private const val supplementIdArg = "supplementId"

internal class SupplementArgs(supplementId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(checkNotNull(savedStateHandle[supplementIdArg]) as String)
}

fun NavGraphBuilder.supplementScreen(
    onNavigateBack: () -> Unit
) {
    composable(Screen.Supplement.route) {
        // inicializar viewmodel aqui
        SupplementScreen(
            onNavigateBack = onNavigateBack
        )
    }
}

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