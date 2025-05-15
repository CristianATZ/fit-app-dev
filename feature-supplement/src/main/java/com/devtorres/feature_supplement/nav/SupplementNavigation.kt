package com.devtorres.feature_supplement.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.core_navigation.Screen
import com.devtorres.feature_supplement.SupplementScreen


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