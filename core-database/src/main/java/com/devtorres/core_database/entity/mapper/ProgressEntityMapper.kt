package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.ProgressEntity
import com.devtorres.core_model.ui.ProgressSummary

object ProgressEntityMapper : EntityMapper<ProgressEntity, ProgressSummary> {

    override fun asEntity(domain: ProgressSummary): ProgressEntity {
        return ProgressEntity(
            id = domain.id,
            exerciseId = domain.exerciseId,
            weight = domain.weight,
            notes = domain.notes,
            reps = domain.reps,
            date = domain.date
        )
    }

    override fun asDomain(entity: ProgressEntity): ProgressSummary {
        return ProgressSummary(
            id = entity.id,
            exerciseId = entity.exerciseId,
            weight = entity.weight,
            notes = entity.notes,
            reps = entity.reps,
            date = entity.date
        )
    }
}

/**
 * Convierte un objeto [ProgressSummary] a un objeto [ProgressEntity].
 */
fun ProgressSummary.asEntity() : ProgressEntity {
    return ProgressEntityMapper.asEntity(this)
}

/**
 * Convierte un objeto [ProgressEntity] a un objeto [ProgressSummary].
 */
fun ProgressEntity.asDomain() : ProgressSummary {
    return ProgressEntityMapper.asDomain(this)
}