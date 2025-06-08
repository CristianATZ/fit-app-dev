package com.devtorres.ui_common.chart

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.chart.ExerciseProgressPoint
import com.jaikeerthick.composable_graphs.composables.line.LineGraph
import com.jaikeerthick.composable_graphs.composables.line.model.LineData
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphColors
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphFillType
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphStyle
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphVisibility
import com.jaikeerthick.composable_graphs.style.LabelPosition

/**
 * Composable que representa un gráfico de líneas personalizado.
 *
 * @property modifier Modificadores para personalizar la apariencia y el comportamiento del gráfico.
 * @property fillType Relleno del grafico degradado.
 * @property lineColor Color de la linea.
 * @property pointColor Color de los puntos.
 * @property data Lista de datos a representar en el gráfico.
 */
@Composable
fun CustomLineGraph(
    modifier: Modifier = Modifier,
    setSelectedPoint: (ExerciseProgressPoint?) -> Unit,
    selectedPoint: ExerciseProgressPoint?,
    fillType: Brush = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        )
    ),
    lineColor: Color = MaterialTheme.colorScheme.primary,
    pointColor: Color = MaterialTheme.colorScheme.primary,
    highlightColor: Color = MaterialTheme.colorScheme.secondary,
    data: List<ExerciseProgressPoint>
) {

    val mappedData = remember { data.toJCGChartLineDataList() }

    // Definimos scroll state para mover horizontalmente
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .horizontalScroll(scrollState)
            .width((data.size * 60).dp)
    ) {
        LineGraph(
            data = mappedData,
            onPointClick = { selected ->
                // mapear
                val mapSelected = selected.toLineChartDataPoint()

                setSelectedPoint(mapSelected)
            },
            style = LineGraphStyle(
                colors = LineGraphColors(
                    lineColor = lineColor,
                    pointColor = pointColor,
                    fillType = LineGraphFillType.Gradient(brush = fillType),
                    clickHighlightColor = highlightColor
                ),
                visibility = LineGraphVisibility(
                    isCrossHairVisible = true,
                    isYAxisLabelVisible = true,
                    isXAxisLabelVisible = true,
                    isGridVisible = false
                ),
                yAxisLabelPosition = LabelPosition.LEFT
            ),
            modifier = modifier
        )
    }
}

/**
 * Conversor de una List de [ExerciseProgressPoint] a una List de [LineData]
 *
 * Evitamos importar la libreria externa [com.jaikeerthick.composable_graphs] en otro modulo.
 *
 */
fun List<ExerciseProgressPoint>.toJCGChartLineDataList(): List<LineData> {
    return this.map { lineChar ->
        LineData(
            x = lineChar.weight.toString(),
            y = lineChar.reps
        )
    }
}

/**
 * Conversor de un [ExerciseProgressPoint] a un [LineData]
 */
fun LineData.toLineChartDataPoint(): ExerciseProgressPoint {
    return ExerciseProgressPoint(
        weight = this.x.toDouble(),
        reps = this.y
    )
}