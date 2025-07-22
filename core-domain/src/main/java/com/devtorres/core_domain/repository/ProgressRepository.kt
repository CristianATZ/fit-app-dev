package com.devtorres.core_domain.repository

import androidx.annotation.WorkerThread
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {

    @WorkerThread
    fun fetchProgressList(
        date: Long,
        exerciseId: String
    ) : Flow<List<ProgressSummary>>

    @WorkerThread
    suspend fun addProgress(
        progressSummary: ProgressSummary,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    )
}