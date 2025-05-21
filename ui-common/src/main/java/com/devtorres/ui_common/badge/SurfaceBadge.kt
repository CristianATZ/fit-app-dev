package com.devtorres.ui_common.badge

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.finager.core.presentation.components.typo.BodySmall

@Composable
fun SurfaceBadge(
    label: String
) {
    Badge(
        containerColor = colorScheme.surface,
        contentColor = colorScheme.onSurface,
        modifier = Modifier.border(
            width = 1.dp,
            color = colorScheme.outline,
            shape = CircleShape
        )
    ) {
        BodySmall(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}