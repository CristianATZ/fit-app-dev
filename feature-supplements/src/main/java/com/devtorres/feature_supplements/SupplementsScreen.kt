package com.devtorres.feature_supplements

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SupplementsScreen(
    drawerState: DrawerState,
    onNavigateToSupplement: () -> Unit
) {
    Text("supplementsScreen")
}