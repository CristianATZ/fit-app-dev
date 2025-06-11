package com.devtorres.core_data

import android.util.Log
import androidx.annotation.WorkerThread
import com.devtorres.core_data.dispatcher.Dispatcher
import com.devtorres.core_data.dispatcher.FitAppDispatchers
import com.devtorres.core_database.dao.ProgressDao
import com.devtorres.core_database.entity.mapper.asDomain
import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProgressRepositoryImp @Inject constructor(
    private val progressDao: ProgressDao
) : ProgressRepository {

    @WorkerThread
    override fun fetchProgressList(
        date: Long,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) : Flow<List<ProgressSummary>> = flow {
        val progressList = progressDao
            .getAllProgressList(
                date = date,
                exerciseId = "Barbell_Bench_Press"
            )
            .map { it.asDomain() }

        Log.d("ProgressRepositoryImp", "fetchProgressList: $progressList")

        emit(progressList)
    }
        .onStart { onStart() }
        .onCompletion { onComplete() }
        .catch { onError(it.message) }
        .flowOn(Dispatchers.IO)

}