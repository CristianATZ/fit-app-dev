package com.devtorres.core_utils

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.devtorres.core_designsystem.MaterialThemeExt
import com.devtorres.core_model.ui.ProgressSummary
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object StringUtils {

    fun calculateDifeferencePercent(
        lastestExercise: Int,
        previousExercise: Int
    ): Int {
        val t = lastestExercise.toDouble()
        val p = previousExercise.toDouble()

        val res = ((t - p) / p) * 100
        return res.toInt()
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

    fun calculateOneRM(weight: Float, reps: Int) : String {
        val res = weight * (1f + (reps / 30f))
        return Math.round(res).toString()
    }

    fun getRelativeDateString(dateTime: LocalDateTime, context: Context): String {
        val zoneId = ZoneId.systemDefault()

        // Convertir a ZonedDateTime y truncar a LocalDate
        val inputDate = dateTime.atZone(zoneId).toLocalDate()
        val nowDate = ZonedDateTime.now(zoneId).toLocalDate()

        val daysBetween = ChronoUnit.DAYS.between(inputDate, nowDate)

        return when {
            daysBetween == 0L -> context.getString(R.string.lb_today)
            daysBetween == 1L -> context.getString(R.string.lb_yesterday)
            daysBetween in 2..6 -> context.getString(R.string.lb_few_days_ago, daysBetween)
            else -> DateTimeFormatter.ofPattern("dd/MM/yyyy").format(inputDate)
        }
    }




    fun getTimeString24h(dateTime: LocalDateTime): String {
        return DateTimeFormatter.ofPattern("HH:mm").format(dateTime)
    }

}