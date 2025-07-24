package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Clase que representa la entidad de progreso de un ejercicio.
 *
 * @property id Identificador único del progreso.
 * @property exerciseId Identificador del ejercicio al que pertenece el progreso.
 * @property weight Peso del progreso (Kgs).
 * @property reps Número de repeticiones del progreso.
 * @property notes Notas adicionales del progreso.
 * @property oneRm Peso máximo calculado del progreso (One RM).
 * @property date Fecha del progreso.
 */
@Entity(
    tableName = "progress"
)
data class ProgressEntity (
    @PrimaryKey val id:         String,
    val exerciseId:             String,
    val weight:                 Float,
    val reps:                   Int,
    val notes:                  String,
    val oneRm:                  Int,
    val date:                   LocalDateTime
)