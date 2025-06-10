package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup

/**
 * Clase que representa la entidad de un ejercicio.
 *
 * @property id Identificador único del ejercicio.
 * @property name Nombre del ejercicio.
 * @property force Tipo de fuerza del ejercicio [ForceType].
 * @property level Nivel del ejercicio [LevelType].
 * @property mechanic Tipo de mecánica del ejercicio [MechanicType].
 * @property equipment Tipo de equipo del ejercicio [EquipmentType].
 * @property primaryMuscles Lista de musculos [MuscleGroup] principales del ejercicio List[MuscleGroup].
 * @property secondaryMuscles Lista de musculos [MuscleGroup] secundarios del ejercicio.
 * @property instructions Instrucciones del ejercicio.
 * @property category Categoría del ejercicio [ExerciseCategory].
 * @property exerciseImages Imagenes del ejercicio.
 * @property equipmentIds Identificadores de los equipos del ejercicio.
 * @property alternative Identificadores de ejercicios alternativos.
 */
@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id:     String,
    val name:               String,
    val force:              ForceType,
    val level:              LevelType,
    val mechanic:           MechanicType,
    val equipment:          EquipmentType,
    val primaryMuscles:     List<MuscleGroup>,
    val secondaryMuscles:   List<MuscleGroup>,
    val instructions:       List<String>,
    val category:           ExerciseCategory,
    val exerciseImages:     List<String>,
    val equipmentIds:       List<String>,
    val alternative:        List<String>
)
