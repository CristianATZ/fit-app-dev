package com.devtorres.ui_common.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.finager.core.presentation.components.typo.BodySmall

@Composable
fun SecondaryBadge(
    label: String,
) {
    Badge(
        containerColor = colorScheme.secondary,
        contentColor = colorScheme.onSecondary
    ) {
        BodySmall(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}