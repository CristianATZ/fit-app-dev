package com.devtorres.core_domain.repository

import androidx.annotation.WorkerThread
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {

    @WorkerThread
    fun fetchProgressList(
        date: Long,
        exerciseId: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) : Flow<List<ProgressSummary>>

    @WorkerThread
    suspend fun addProgress(
        progressSummary: ProgressSummary,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    )

    @WorkerThread
    fun getTotalProgressCount(
        exerciseId: String
    ) : Flow<Int>

    @WorkerThread
    fun getMaxProgressOneRm(
        exerciseId: String
    ) : Flow<ProgressSummary?>

    fun getLastTwoOneRm(
        exerciseId: String
    ) : Flow<List<Int>>
}