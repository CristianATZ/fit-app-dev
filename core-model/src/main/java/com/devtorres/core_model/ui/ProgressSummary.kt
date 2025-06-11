package com.devtorres.core_model.ui

import java.time.LocalDateTime

data class ProgressSummary(
    val id:                 String,
    val exerciseId:         String,
    val weight:             Float,
    val reps:               Int,
    val date:               LocalDateTime
) {
    // hacer una funcion para obtener las horas en formaro 24 HRS

    /*
    Hacer una funcion para obtener la fecha en formato
    Hoy
    Ayer
    Hace 2..6 dias
    Hace 1..3 semanas
    Hacer mas de 3 semanas
    dd/mm/yyyy
     */
}