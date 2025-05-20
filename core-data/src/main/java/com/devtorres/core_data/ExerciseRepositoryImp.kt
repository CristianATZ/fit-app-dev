package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_domain.ExerciseRepository
import com.devtorres.core_model.ExerciseDto
import com.devtorres.core_model.ExerciseUI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepositoryImp @Inject constructor(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {

    @WorkerThread
    override suspend fun insertExercises(exerciseDtos: List<ExerciseDto>) {
        try {
            exerciseDao.insertExercises(exerciseDtos.map { it.asEntity() })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @WorkerThread
    override suspend fun getExercises(): List<ExerciseUI> {
        return emptyList()
    }
}