package com.devtorres.core_domain

import com.devtorres.core_domain.repository.ProgressRepository
import com.devtorres.core_model.ui.ProgressSummary
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class GetProgressListUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {
    operator fun invoke(
        minusMonth: Long,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) : Flow<List<ProgressSummary>> {
        val fetchingMonth = LocalDateTime.now()
            .withDayOfMonth(1)
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0)
            .minusMonths(minusMonth)
            .toEpochSecond(ZoneOffset.UTC)

        return progressRepository.fetchProgressList(
            date = fetchingMonth,
            onStart = onStart,
            onComplete = onComplete,
            onError = onError
        )
    }
}