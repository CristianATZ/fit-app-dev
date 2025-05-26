package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.ui.ExerciseAlternative

fun ExerciseEntity.asExerciseAlternative() : ExerciseAlternative {
    return ExerciseAlternative(
        id = this.id,
        name = this.name
    )
}