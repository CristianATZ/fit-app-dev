package com.devtorres.feature_exercise.fragments.progressTab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.chart.ExerciseProgressPoint
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.chart.CustomLineGraph
import com.devtorres.ui_common.typo.HeadLineSmall
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ProgressChartTab(
    exerciseName: String,
    progressList: List<ProgressSummary>,
) {

    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            HeadLineSmall(
                stringResId = R.string.chart_title_upper,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            LabelLarge(
                text = stringResource(R.string.chart_description, exerciseName),
                modifier = Modifier.alpha(0.5f)
            )

            Spacer(Modifier.size(12.dp))

            // cambiar al viewmodel
            val (selectedPoint, setSelectedPoint) = remember { mutableStateOf<ExerciseProgressPoint?>(null) }

            CardSelectedInformation(
                selectedPoint = selectedPoint
            )

            Spacer(Modifier.size(32.dp))

            CustomLineGraph(
                data = progressList,
                lineColor = colorScheme.secondary,
                pointColor = colorScheme.secondary,
                highlightColor = Color.Black,
                fillType = Brush.verticalGradient(
                    colors = listOf(
                        colorScheme.secondary,
                        colorScheme.secondary.copy(alpha = 0f)
                    )
                ),
                selectedPoint = selectedPoint,
                setSelectedPoint = setSelectedPoint
            )

            Spacer(Modifier.size(16.dp))
        }
    }
}

@Composable
private fun CardSelectedInformation(
    selectedPoint: ExerciseProgressPoint?
) {
    OutlinedCard(
        shape = shapes.medium,
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.background
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Row {
                LabelLarge(
                    stringResId = R.string.lblWeight,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.size(4.dp))
                LabelLarge(
                    text = stringResource(
                        R.string.lblKg,
                        (selectedPoint?.weight ?: 0.0).toString()
                    )
                )
            }

            Spacer(Modifier.size(16.dp))

            Row {
                LabelLarge(
                    stringResId = R.string.lblRepetitions,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.size(4.dp))
                LabelLarge(
                    text = (selectedPoint?.reps ?: 0).toString()
                )
            }
        }
    }
}
