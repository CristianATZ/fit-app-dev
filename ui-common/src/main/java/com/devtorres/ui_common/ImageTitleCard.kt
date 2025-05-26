package com.devtorres.ui_common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.image.AsyncImageLoader
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ImageTitleCard(
    folderPath: String,
    title: String,
    onClick: () -> Unit
) {
    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        onClick = onClick,
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium
    ) {
        Column(
            modifier = Modifier
                .width(175.dp)
                .heightIn(min = 175.dp)
        ) {
            AsyncImageLoader(
                folderPath = folderPath,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp)
            )

            LabelLarge(
                text = title,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}