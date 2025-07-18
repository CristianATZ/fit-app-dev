package com.devtorres.core_utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.devtorres.core_designsystem.MaterialThemeExt
import com.devtorres.core_model.ui.ProgressSummary

object StringUtils {

    fun calculateDifeferencePercent(
        lastestExercise: ProgressSummary,
        previousExercise: ProgressSummary
    ): Int {
        val t = lastestExercise.calculateOneRM().toDouble()
        val p = previousExercise.calculateOneRM().toDouble()

        val res = ((t - p) / p) * 100
        return res.toInt() // Por ejemplo: "5.0"
    }

    @Composable
    fun setColorToPercentage(percent: Int?): Color {
        if (percent == null) return MaterialTheme.colorScheme.secondary

        return when {
            percent > 0 -> MaterialThemeExt.colors.green.color
            percent < 0 -> MaterialTheme.colorScheme.error
            else -> MaterialTheme.colorScheme.secondary
        }
    }
}