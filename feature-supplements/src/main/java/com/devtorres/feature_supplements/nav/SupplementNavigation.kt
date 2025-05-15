package com.devtorres.feature_supplements.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devtorres.feature_supplements.SupplementScreen

private const val supplementIdArg = "supplementId"

internal sealed class SupplementScreen(val route: String) {
    data object Detail : SupplementScreen("supplement/{$supplementIdArg}") {
        fun createRoute(id: String) = "supplement/$id"
    }
}

fun NavGraphBuilder.supplementScreen(
    onNavigateBack: () -> Unit
) {
    composable(SupplementScreen.Detail.route) {
        // inicializar viewmodel aqui
        SupplementScreen(
            onNavigateBack = onNavigateBack
        )
    }
}

fun NavController.navigateToSupplement(supplementId: String) {
    this.navigate(SupplementScreen.Detail.createRoute(supplementId))
}

internal class SupplementArgs(supplementId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(checkNotNull(savedStateHandle[supplementIdArg]) as String)
}