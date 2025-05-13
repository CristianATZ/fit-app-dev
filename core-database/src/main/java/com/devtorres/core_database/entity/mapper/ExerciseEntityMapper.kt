package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.Exercise

object ExerciseEntityMapper : EntityMapper<ExerciseEntity, Exercise> {
    override fun asEntity(domain: Exercise): ExerciseEntity {
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

    override fun asDomain(entity: ExerciseEntity): Exercise {
        return Exercise(
            id = entity.id,
            name = entity.name,
            force = entity.force,
            level = entity.level,
            mechanic = entity.mechanic,
            equipment = entity.equipment,
            primaryMuscles = entity.primaryMuscles,
            secondaryMuscles = entity.secondaryMuscles,
            instructions = entity.instructions,
            category = entity.category,
            exerciseImages = entity.exerciseImages,
            equipmentIds = entity.equipmentIds,
            alternative = entity.alternative
        )
    }

}

fun Exercise.asEntity() : ExerciseEntity {
    return ExerciseEntityMapper.asEntity(this)
}

fun ExerciseEntity.asDomain() : Exercise {
    return ExerciseEntityMapper.asDomain(this)
}