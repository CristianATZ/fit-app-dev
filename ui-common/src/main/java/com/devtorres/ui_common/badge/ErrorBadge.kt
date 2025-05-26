package com.devtorres.ui_common.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.finager.core.presentation.components.typo.BodySmall

@Composable
fun ErrorBadge(
    label: String
) {
    Badge {
        BodySmall(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}