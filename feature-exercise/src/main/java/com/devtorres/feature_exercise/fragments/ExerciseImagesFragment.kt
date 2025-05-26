package com.devtorres.feature_exercise.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.image.AsyncImageLoader

@Composable
fun ExerciseImagesFragment(
    imageUris: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        imageUris.forEach { uri ->
            AsyncImageLoader(
                folderPath = uri,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shapes.medium)
            )
        }
    }
}