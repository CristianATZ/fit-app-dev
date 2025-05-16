package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExercisesScreen(
    onNavigateToExercise: () -> Unit,
    drawerState: DrawerState
) {
    Column(
        modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())
    ) {
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