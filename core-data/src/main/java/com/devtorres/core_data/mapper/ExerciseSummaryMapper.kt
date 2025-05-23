package com.devtorres.core_data.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.ui.ExerciseSummaryUI


object ExerciseSummaryMapper {
    fun ExerciseEntity.asExerciseSummary() : ExerciseSummaryUI {
        return ExerciseSummaryUI(
            id = this.id,
            name = this.name,
            level = this.level,
            mechanic = this.mechanic,
            equipment = this.equipment,
            category = this.category,
            primaryMuscles = this.primaryMuscles,
            secondaryMuscles = this.secondaryMuscles,
            exerciseImages = this.exerciseImages
        )
    }
}