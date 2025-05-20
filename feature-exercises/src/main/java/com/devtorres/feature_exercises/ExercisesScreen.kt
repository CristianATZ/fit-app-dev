package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExercisesScreen(
    onNavigateToExercise: () -> Unit,
    innerPadding: PaddingValues
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(innerPadding)
    ) {
        item {

        }
    }
}