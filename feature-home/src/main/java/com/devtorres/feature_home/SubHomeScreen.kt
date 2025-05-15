package com.devtorres.feature_home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SubHomeScreen(
    onNavigateToExercises: () -> Unit,
    onNavigateToSupplements: () -> Unit,
    drawerState: DrawerState,
    onNavigateToRoutines: () -> Unit
) {
    Surface {
        Column {
            Text("subHome")

            Button(
                onClick = {
                    onNavigateToExercises()
                }
            ) {
                Text("Ir a ejercicio")
            }

            Button(
                onClick = {
                    onNavigateToRoutines()
                }
            ) {
                Text("Ir a rutinas")
            }

            Button(
                onClick = {
                    onNavigateToSupplements()
                }
            ) {
                Text("Ir a suplementos")
            }
        }
    }
}