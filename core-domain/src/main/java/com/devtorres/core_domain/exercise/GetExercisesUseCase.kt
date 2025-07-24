package com.devtorres.core_domain.exercise

import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_model.ui.ExerciseSummaryUI
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) {

    suspend operator fun invoke() : List<ExerciseSummaryUI> {
        val summaryExercises = exerciseRepository.getExercises()

        // CAMBIAR
        return summaryExercises
    }
}