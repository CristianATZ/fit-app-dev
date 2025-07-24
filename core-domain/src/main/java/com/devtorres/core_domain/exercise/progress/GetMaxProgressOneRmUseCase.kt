package com.devtorres.core_domain.exercise.progress

import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMaxProgressOneRmUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {

    operator fun invoke(
        exerciseId: String
    ) : Flow<ProgressSummary?> =
        progressRepository.getMaxProgressOneRm(exerciseId)
}