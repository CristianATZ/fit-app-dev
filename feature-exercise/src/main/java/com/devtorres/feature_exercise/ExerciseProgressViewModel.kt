package com.devtorres.feature_exercise

import android.util.Log
import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_domain.AddProgressUseCase
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_domain.GetProgressListUseCase
import com.devtorres.core_model.ui.BreadcrumbItem
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.core_utils.Validators
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseProgressViewModel @Inject constructor(
    breadcrumbsManager: BreadcrumbsManager,
    private val getProgressListUseCase: GetProgressListUseCase,
    private val addProgressUseCase: AddProgressUseCase
) : ViewModel() {

    private val _progressStateForm = MutableStateFlow(ProgressForm())
    val progressStateForm: StateFlow<ProgressForm> = _progressStateForm.asStateFlow()

    private val currentFetchingMonth = MutableStateFlow<Long>(0)

    var isLoading by mutableStateOf(true)
        private set

    var toastMessage by mutableStateOf<String?>(null)
        private set

    /**
     * Se alimenta del historial del [BreadcrumbsManager].
     *
     * Obtiene el ultimo de la lista para obtener el ID del ejercicio.
     */
    val exerciseBreadCrumb: StateFlow<BreadcrumbItem?> = breadcrumbsManager
        .getLastIem()
        .filterNotNull()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    /**
     * Utiliza dos Flows combinados.
     *
     * [exerciseBreadCrumb] para obtener el ID del ejercicio.
     * [currentFetchingMonth] para obtener la cantidad de meses a restar.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    private val progressListFlow: Flow<List<ProgressSummary>> =
        combine(
            exerciseBreadCrumb,
            currentFetchingMonth
        ) { exerciseId, currentFetchingMonth ->
            exerciseId to currentFetchingMonth
        }.flatMapLatest { (exerciseId, minusMonth) ->
            Log.d("ExerciseProgressViewModel", "exerciseId: $exerciseId, minusMonth: $minusMonth")
            getProgressListUseCase(
                minusMonth = minusMonth,
                exerciseId = exerciseId?.id ?: "",
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

    fun onEvent(event: ProgressEvent) {
        when (event) {
            is ProgressEvent.OnAddProgress -> addProgress()
            is ProgressEvent.OnNotesChange -> updateNotes(event.notes)
            is ProgressEvent.OnRepsChange -> updateReps(event.reps)
            is ProgressEvent.OnWeightChange -> updateWeight(event.weight)
        }
    }

    // guardarlo en room
    private fun addProgress() {
        viewModelScope.launch {
            exerciseBreadCrumb.value?.let { breadcrumbItem ->
                Log.d("ExerciseProgressViewModel", "boton picado")
                addProgressUseCase(
                    exerciseId = breadcrumbItem.id,
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
    }

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
    data class OnWeightChange(val weight: String) : ProgressEvent()
    data class OnRepsChange(val reps: String) : ProgressEvent()
    data class OnNotesChange(val notes: String) : ProgressEvent()
    data object OnAddProgress : ProgressEvent()
}

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