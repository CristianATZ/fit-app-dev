package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.dao.ProgressDao
import com.devtorres.core_database.entity.mapper.asDomain
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_di.IoDispatcher
import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.core_utils.StringUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToInt

@Singleton
class ProgressRepositoryImp @Inject constructor(
    private val progressDao: ProgressDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
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

        emit(progressList)
    }
        .onStart { onStart() }
        .onCompletion { onComplete() }
        .catch { onError(it.message) }
        .flowOn(ioDispatcher)

    @WorkerThread
    override suspend fun addProgress(
        progressSummary: ProgressSummary,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) {
        onStart()

        delay(1000)

        try {
            withContext(ioDispatcher) {
                progressDao.insertProgress(progressSummary.asEntity())
            }

            onComplete()
        } catch (e: Exception) {
            onError(e.message)
        }
    }

    @WorkerThread
    override fun getTotalProgressCount(exerciseId: String): Flow<Int> =
        progressDao.getTotalProgressCount(exerciseId = exerciseId)
            .flowOn(ioDispatcher)

    @WorkerThread
    override fun getMaxProgressOneRm(exerciseId: String): Flow<ProgressSummary?> =
        progressDao.getMaxProgressOneRm(exerciseId = exerciseId)
            .map { it?.asDomain() }
            .flowOn(ioDispatcher)

    @WorkerThread
    override fun getLastTwoOneRm(exerciseId: String): Flow<List<Int>> =
        progressDao.getLastTwoProgress(exerciseId = exerciseId)
            .flowOn(ioDispatcher)

}