package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_model.Exercise
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImp @Inject constructor(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {

    @WorkerThread
    override suspend fun insertExercises(exercises: List<Exercise>) {
        try {
            exerciseDao.insertExercises(exercises.map { it.asEntity() })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}