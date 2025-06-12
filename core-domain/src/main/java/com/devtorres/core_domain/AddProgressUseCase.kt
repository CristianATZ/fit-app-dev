package com.devtorres.core_domain

import android.util.Log
import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject

class AddProgressUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {

    suspend operator fun invoke(
        exerciseId: String,
        weight: String,
        reps: String,
        notes: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) {
        val progressSummary = ProgressSummary(
            id = UUID.randomUUID().toString(),
            exerciseId = exerciseId,
            weight = weight.toFloat(),
            reps = reps.toInt(),
            notes = notes,
            date = LocalDateTime.now()
        )

        Log.d("ExerciseProgressViewModel", "caso de uso")
        progressRepository.addProgress(
            progressSummary = progressSummary,
            onStart = onStart,
            onComplete = onComplete,
            onError = onError
        )
    }
}