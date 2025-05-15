package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ExercisesScreen(onNavigateToExercise: () -> Unit, drawerState: DrawerState) {
    Surface {
        Column {
            Text("exercisesScreen")

            Button(
                onClick = {
                    onNavigateToExercise()
                }
            ) {
                Text("Ir a ejercicio")
            }
        }
    }
}