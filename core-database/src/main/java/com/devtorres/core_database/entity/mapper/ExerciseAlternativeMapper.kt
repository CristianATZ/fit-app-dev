package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.ui.ExerciseAlternative

object ExerciseAlternativeMapper  {

    fun asDomain(domain: List<ExerciseEntity>) : List<ExerciseAlternative> {
        return domain.map {
            ExerciseAlternative(
                id = it.id,
                name = it.name
            )
        }
    }
}

fun List<ExerciseEntity>.asExerciseAlternative() : List<ExerciseAlternative> {
    return ExerciseAlternativeMapper.asDomain(this)
}