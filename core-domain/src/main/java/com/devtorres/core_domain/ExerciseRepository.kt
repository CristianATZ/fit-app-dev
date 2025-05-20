package com.devtorres.core_domain

import androidx.annotation.WorkerThread
import com.devtorres.core_model.ExerciseDto
import com.devtorres.core_model.ExerciseUI

interface ExerciseRepository {

    @WorkerThread
    suspend fun insertExercises(exerciseDtos: List<ExerciseDto>)

    @WorkerThread
    suspend fun getExercises(): List<ExerciseUI>
}