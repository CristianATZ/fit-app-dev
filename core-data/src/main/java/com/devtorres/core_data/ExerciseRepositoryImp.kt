package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.ExerciseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImp @Inject constructor(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {

    @WorkerThread
    override suspend fun insertExercises(exercises: List<ExerciseEntity>) {
        try {
            exerciseDao.insertExercises(exercises)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}