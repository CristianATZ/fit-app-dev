package com.devtorres.core_domain.repository

import androidx.annotation.WorkerThread
import com.devtorres.core_model.ui.ExerciseSummaryUI

interface ExerciseRepository {
    @WorkerThread
    suspend fun getExercises(): List<ExerciseSummaryUI>
}