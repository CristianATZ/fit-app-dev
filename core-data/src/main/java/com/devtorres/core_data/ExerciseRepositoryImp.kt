package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_data.mapper.ExerciseSummaryMapper.asExerciseSummary
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_model.ui.ExerciseSummaryUI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImp @Inject constructor(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {

    @WorkerThread
    override suspend fun getExercises(): List<ExerciseSummaryUI> {
        return exerciseDao.getExercises().map { it.asExerciseSummary() }
    }
}