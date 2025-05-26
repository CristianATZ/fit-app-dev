package com.devtorres.core_data

import androidx.annotation.WorkerThread
import com.devtorres.core_data.mapper.ExerciseSummaryMapper.asExerciseSummary
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.mapper.asExerciseAlternative
import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_model.ui.EquipmentDetail
import com.devtorres.core_model.ui.ExerciseAlternative
import com.devtorres.core_model.ui.ExerciseDetail
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

    @WorkerThread
    override suspend fun getExerciseDetail(exerciseId: String): ExerciseDetail {
        // 1. obtenemos la entidad base
        val exerciseEntity = exerciseDao.getExerciseById(exerciseId = exerciseId)

        // 2. Mapeamos equipmentsIds -> List<EquipmentDetail>
        // obtenemos de la base de datos
        val equipmentDetails = emptyList<EquipmentDetail>()

        // 3. Mapeamos alternative -> List<ExerciseAlternative>
        val alternativeExercises = if(exerciseEntity.alternative.isNotEmpty()) {
            exerciseDao.getAlternativeNames(exerciseIds = exerciseEntity.alternative)
        } else {
            emptyList()
        }

        val alternativeDetails = alternativeExercises.map {
            it.asExerciseAlternative()
        }

        // 4. Construimos el objeto ExerciseDetail
        return ExerciseDetail(
            id = exerciseEntity.id,
            name = exerciseEntity.name,
            force = exerciseEntity.force,
            level = exerciseEntity.level,
            mechanic = exerciseEntity.mechanic,
            equipment = exerciseEntity.equipment,
            primaryMuscles = exerciseEntity.primaryMuscles,
            secondaryMuscles = exerciseEntity.secondaryMuscles,
            instructions = exerciseEntity.instructions,
            category = exerciseEntity.category,
            exerciseImages = exerciseEntity.exerciseImages,
            equipments = equipmentDetails,
            alternative = alternativeDetails
        )
    }
}