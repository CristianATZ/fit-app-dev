package com.devtorres.core_domain.repository

import androidx.annotation.WorkerThread
import com.devtorres.core_model.ui.ExerciseDetail
import com.devtorres.core_model.ui.ExerciseSummaryUI

interface ExerciseRepository {
    @WorkerThread
    suspend fun getExercises(): List<ExerciseSummaryUI>

    @WorkerThread
    suspend fun getExerciseDetail(exerciseId: String): ExerciseDetail
}