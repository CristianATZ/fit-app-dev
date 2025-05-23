package com.devtorres.feature_exercises.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable

@Composable
fun ExercisesListShimmerEffect() {
    CircularProgressIndicator(
        color = colorScheme.secondary
    )
}