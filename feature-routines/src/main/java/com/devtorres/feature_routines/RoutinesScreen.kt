package com.devtorres.feature_routines

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RoutinesScreen(
    drawerState: DrawerState,
    onNavigateToRoutine: () -> Unit
) {
    Surface {
        Column {
            Text("routinesScreen")

            Button(
                onClick = {
                    onNavigateToRoutine()
                }
            ) {
                Text("Ir a rutina")
            }
        }
    }
}