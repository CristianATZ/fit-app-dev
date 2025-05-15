package com.devtorres.feature_home

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SubHomeScreen(
    onNavigateToExercise: () -> Unit,
    onNavigateToSupplement: () -> Unit,
    drawerState: DrawerState
) {
    Text("subHome")
}