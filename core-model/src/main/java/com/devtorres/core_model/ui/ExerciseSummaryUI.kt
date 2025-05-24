package com.devtorres.core_model.ui

import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup

data class ExerciseSummaryUI(
    val id: String,
    val name: String,
    val level: LevelType,
    val mechanic: MechanicType,
    val equipment: EquipmentType,
    val category: ExerciseCategory,
    val primaryMuscles: List<MuscleGroup>,
    val secondaryMuscles: List<MuscleGroup>,
    val exerciseImages: List<String>
) {
    fun getPreviewImageUri() : String {
        return "exercises/${id.lowercase()}/${exerciseImages[0]}"
    }
}
