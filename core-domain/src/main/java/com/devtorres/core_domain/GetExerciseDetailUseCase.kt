package com.devtorres.core_domain

import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_model.ui.ExerciseDetail
import javax.inject.Inject

class GetExerciseDetailUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) {
    suspend operator fun invoke(exerciseId: String) : ExerciseDetail {
        return exerciseRepository.getExerciseDetail(exerciseId)
    }
}