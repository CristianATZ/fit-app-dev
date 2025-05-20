package com.devtorres.core_domain

import androidx.annotation.WorkerThread
import com.devtorres.core_model.Exercise

interface ExerciseRepository {

    @WorkerThread
    suspend fun insertExercises(exercises: List<Exercise>)

    @WorkerThread
    suspend fun getExercises(): List<Exercise>
}