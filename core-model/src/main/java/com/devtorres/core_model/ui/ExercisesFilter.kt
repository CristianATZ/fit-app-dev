package com.devtorres.core_model.ui

import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup

data class ExercisesFilter(
    val selectedMuscles: Set<MuscleGroup> = emptySet(),
    val levels: Set<LevelType> = emptySet(),
    val mechanics: Set<MechanicType> = emptySet(),
    val forces: Set<ForceType> = emptySet(),
    val equipment: Set<EquipmentType> = emptySet(),
    val categories: Set<ExerciseCategory> = emptySet(),
    val searchQuery: String = ""
)