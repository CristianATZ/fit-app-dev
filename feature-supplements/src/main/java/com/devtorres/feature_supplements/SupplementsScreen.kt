package com.devtorres.feature_supplements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SupplementsScreen(
    drawerState: DrawerState,
    onNavigateToSupplement: () -> Unit
) {
    Surface {
        Column {
            Text("supplementsScreen")

            Button(
                onClick = {
                    onNavigateToSupplement()
                }
            ) {
                Text("Ir a suplemento")
            }
        }
    }
}