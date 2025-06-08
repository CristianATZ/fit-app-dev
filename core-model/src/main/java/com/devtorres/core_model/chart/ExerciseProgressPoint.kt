package com.devtorres.core_model.chart

/**
 * Representa un punto en un gráfico de líneas.
 *
 * @property weight Valor en el eje X, representa el peso utilizado en la serie.
 * @property reps Valor numérico en el eje Y, representa la cantidad de repeticiones.
 */
data class ExerciseProgressPoint(
    val weight: Double,
    val reps: Number
)