package com.devtorres.core_data.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.ui.ExerciseSummaryUI


object ExerciseSummaryMapper {
    fun ExerciseEntity.asExerciseSummary() : ExerciseSummaryUI {
        return ExerciseSummaryUI(
            id = this.id,
            name = this.name,
            level = this.level,
            equipment = this.equipment,
            category = this.category,
            primaryMuscles = this.primaryMuscles,
            secondaryMuscles = this.secondaryMuscles,
            exerciseImages = this.exerciseImages
        )
    }
}

/*
object ExerciseMapper : EntityMapper<ExerciseEntity, Exercise> {
    override fun asEntity(domain: ExerciseUI): ExerciseEntity {
        TODO("Not yet implemented")
    }

    override fun asDomain(entity: ExerciseEntity): ExerciseUI {
        TODO("Not yet implemented")
    }
}

fun Exercise.asEntity() : ExerciseEntity {
    return ExerciseMapper.asEntity(this)
}

fun ExerciseEntity.asDomain() : ExerciseUI {
    return ExerciseMapper.asDomain(this)
}*/
