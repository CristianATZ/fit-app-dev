package com.devtorres.feature_routines

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RoutinesScreen(
    drawerState: DrawerState,
    onNavigateToRoutine: () -> Unit
) {
    Text("routinesScreen")
}