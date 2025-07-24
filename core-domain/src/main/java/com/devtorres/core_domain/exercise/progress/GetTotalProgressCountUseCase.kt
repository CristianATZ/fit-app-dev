package com.devtorres.core_domain.exercise.progress

import com.devtorres.core_domain.repository.ProgressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalProgressCountUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {
    operator fun invoke(
        exerciseId: String
    ) : Flow<Int> = progressRepository
        .getTotalProgressCount(
            exerciseId = exerciseId
        )
}