package com.devtorres.core_data

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import com.devtorres.core_database.dao.ProgressDao
import com.devtorres.core_database.entity.mapper.asDomain
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
        exerciseId: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) : Flow<List<ProgressSummary>> = flow {

        val progressList = progressDao
            .getAllProgressList(
                date = date,
                exerciseId = exerciseId
            )
            .map { it.asDomain() }

        Log.d("ExerciseProgressViewModel", "progressList: $progressList")
        emit(progressList)
    }
        .onStart { onStart() }
        .onCompletion { onComplete() }
        .catch { onError(it.message) }
        .flowOn(Dispatchers.IO)

    @WorkerThread
    override suspend fun addProgress(
        progressSummary: ProgressSummary,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) {
        Log.d("ExerciseProgressViewModel", "inicio funcion")
        onStart()

        delay(1000)

        try {
            progressDao.insertProgress(progressSummary.asEntity())
            Log.d("ExerciseProgressViewModel", "insertado correctamente")
            onComplete()
        } catch (e: Exception) {
            Log.d("ExerciseProgressViewModel", "fallo")
            onError(e.message)
        }
    }

}