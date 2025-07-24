package com.devtorres.feature_exercise

import android.util.Log
import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_di.MainDispatcher
import com.devtorres.core_domain.AddProgressUseCase
import com.devtorres.core_domain.exercise.progress.GetLastTwoProgressOneRmUseCase
import com.devtorres.core_domain.exercise.progress.GetMaxProgressOneRmUseCase
import com.devtorres.core_domain.exercise.GetProgressListUseCase
import com.devtorres.core_domain.exercise.progress.GetTotalProgressCountUseCase
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.core_utils.Validators
import com.devtorres.feature_exercise.nav.ExerciseArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseProgressViewModel @Inject constructor(
    private val getProgressListUseCase: GetProgressListUseCase,
    private val getTotalProgressCountUseCase: GetTotalProgressCountUseCase,
    private val getMaxProgressOneRmUseCase: GetMaxProgressOneRmUseCase,
    private val getLastTwoProgressOneRmUseCase: GetLastTwoProgressOneRmUseCase,
    private val addProgressUseCase: AddProgressUseCase,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val exerciseId = MutableStateFlow(ExerciseArgs(savedStateHandle).exerciseId)

    private val _progressStateForm = MutableStateFlow(ProgressForm())
    val progressStateForm: StateFlow<ProgressForm> = _progressStateForm.asStateFlow()

    private val currentFetchingMonth = MutableStateFlow<Long>(0)

    var isLoading by mutableStateOf(true)
        private set

    var toastMessage by mutableStateOf<String?>(null)
        private set


    @OptIn(ExperimentalCoroutinesApi::class)
    private val progressListFlow: Flow<List<ProgressSummary>> =
        combine(
            exerciseId,
            currentFetchingMonth
        ) { exerciseId, currentFetchingMonth ->
            exerciseId to currentFetchingMonth
        }.flatMapLatest { (exerciseId, minusMonth) ->
            delay(1_000L)

            getProgressListUseCase(
                minusMonth = minusMonth,
                exerciseId = exerciseId,
                onStart = { isLoading = true },
                onComplete = { isLoading = false },
                onError = { toastMessage = it }
            )
        }

    /**
     * Lista de progreso del ejercicio, depende directamente del Flow de [progressListFlow]
     */
    val progressList: StateFlow<List<ProgressSummary>> = progressListFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val progressCardState: StateFlow<ProgressCardState> = exerciseId.flatMapLatest {
        combine(
            getTotalProgressCountUseCase(it),
            getMaxProgressOneRmUseCase(it),
            getLastTwoProgressOneRmUseCase(it)
        ) { totalProgressCount, maxProgressOneRm, lastTwoProgressOneRm ->
            ProgressCardState(
                totalSeries = totalProgressCount,
                maxOneRm = maxProgressOneRm,
                lastTwoOneRm = lastTwoProgressOneRm
            )
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ProgressCardState()
    )

    fun onEvent(event: ProgressEvent) {
        when (event) {
            is ProgressEvent.OnAddProgress -> addProgress()
            is ProgressEvent.OnNotesChange -> updateNotes(event.notes)
            is ProgressEvent.OnRepsChange -> updateReps(event.reps)
            is ProgressEvent.OnWeightChange -> updateWeight(event.weight)
            is ProgressEvent.OnExerciseChange -> updateExerciseId(event.exerciseId)
        }
    }

    // guardarlo en room
    private fun addProgress() {
        viewModelScope.launch {
            addProgressUseCase(
                exerciseId = exerciseId.value,
                weight = progressStateForm.value.weight.trim(),
                reps = progressStateForm.value.reps.trim(),
                notes = progressStateForm.value.notes.trim(),
                onStart = {
                    _progressStateForm.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                },
                onComplete = {
                    _progressStateForm.update {
                        it.copy(
                            isLoading = false,
                            isComplete = true
                        )
                    }
                },
                onError = {
                    _progressStateForm.update {
                        it.copy(
                            isLoading = false,
                            isComplete = false,
                            isError = true
                        )
                    }
                    toastMessage = it
                }
            )

            if(_progressStateForm.value.isComplete) {
                delay(1500)

                _progressStateForm.update { ProgressForm() }
            }
        }
    }

    @MainThread
    private fun updateExerciseId(newId: String) {
        viewModelScope.launch(mainDispatcher) {
            Log.d("ExerciseProgressViewModel", "updateExerciseId: $newId")
            exerciseId.value = newId
        }
    }

    // mandar a otro viewmodel
    @MainThread
    private fun setFetchingMonth(month: Long) {
        viewModelScope.launch {
            if(!isLoading) {
                currentFetchingMonth.value++
            }
        }
    }

    @MainThread
    private fun updateWeight(weight: String) {
        viewModelScope.launch {
            _progressStateForm.update {
                it.copy(
                    weight = weight,
                    isWeightError = !Validators.isWeightValid(weight)
                )
            }
        }
    }

    @MainThread
    private fun updateReps(reps: String) {
        viewModelScope.launch {
            _progressStateForm.update {
                it.copy(
                    reps = reps,
                    isRepsError = !Validators.isRepsValid(reps)
                )
            }
        }
    }

    @MainThread
    private fun updateNotes(notes: String) {
        viewModelScope.launch {
            _progressStateForm.update {
                it.copy(
                    notes = notes
                )
            }
        }
    }
}

sealed class ProgressEvent {
    data class OnExerciseChange(val exerciseId: String) : ProgressEvent()
    data class OnWeightChange(val weight: String) : ProgressEvent()
    data class OnRepsChange(val reps: String) : ProgressEvent()
    data class OnNotesChange(val notes: String) : ProgressEvent()
    data object OnAddProgress : ProgressEvent()
}

data class ProgressCardState(
    val totalSeries: Int = 0,
    val maxOneRm: ProgressSummary? = null,
    val lastTwoOneRm: List<Int> = emptyList()
)

data class ProgressForm(
    val weight: String = "",
    val isWeightError: Boolean = false,
    val reps: String = "",
    val isRepsError: Boolean = false,
    val notes: String = "",
    // estados al guardar un progreso
    val isLoading: Boolean = false,
    val isComplete: Boolean = false,
    val isError: Boolean = false
)