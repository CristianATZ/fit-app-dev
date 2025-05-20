package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.ExerciseDto

object ExerciseDtoToEntityMapper {
    fun asEntity(domain: ExerciseDto): ExerciseEntity {
        return ExerciseEntity(
            id = domain.id,
            name = domain.name,
            force = domain.force,
            level = domain.level,
            mechanic = domain.mechanic,
            equipment = domain.equipment,
            primaryMuscles = domain.primaryMuscles,
            secondaryMuscles = domain.secondaryMuscles,
            instructions = domain.instructions,
            category = domain.category,
            exerciseImages = domain.exerciseImages,
            equipmentIds = domain.equipmentIds,
            alternative = domain.alternative
        )
    }
}

fun ExerciseDto.asEntity() : ExerciseEntity {
    return ExerciseDtoToEntityMapper.asEntity(this)
}