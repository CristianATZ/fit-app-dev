package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_model.Exercise

interface ExerciseRepository {

    @WorkerThread
    suspend fun insertExercises(exercises: List<Exercise>)
}