package com.devtorres.feature_exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseProgressViewModel @Inject constructor(

) : ViewModel() {

    private val _progressStateForm = MutableStateFlow(ProgressForm())
    val progressStateForm: StateFlow<ProgressForm> = _progressStateForm.asStateFlow()

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

    }

    private fun updateWeight(weight: String) {
        viewModelScope.launch {
            _progressStateForm.update {
                it.copy(
                    weight = weight
                )
            }
        }
    }

    private fun updateReps(reps: String) {
        viewModelScope.launch {
            _progressStateForm.update {
                it.copy(
                    reps = reps
                )
            }
        }
    }

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
    val reps: String = "",
    val notes: String = ""
)