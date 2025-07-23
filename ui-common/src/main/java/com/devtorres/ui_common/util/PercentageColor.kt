package com.devtorres.ui_common.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.devtorres.core_designsystem.MaterialThemeExt

@Composable
fun setColorToPercentage (percent: Int?): Color {
    if (percent == null) return MaterialTheme.colorScheme.secondary

    return when {
        percent > 0 -> MaterialThemeExt.colors.green.color
        percent < 0 -> MaterialTheme.colorScheme.error
        else -> MaterialTheme.colorScheme.secondary
    }
}