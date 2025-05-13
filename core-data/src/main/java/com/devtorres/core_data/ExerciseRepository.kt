package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.entity.ExerciseEntity

interface ExerciseRepository {

    @WorkerThread
    suspend fun insertExercises(exercises: List<ExerciseEntity>)
}