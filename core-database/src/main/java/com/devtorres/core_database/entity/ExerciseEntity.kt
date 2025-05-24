package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id: String,
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
