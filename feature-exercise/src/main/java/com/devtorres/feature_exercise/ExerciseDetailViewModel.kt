package com.devtorres.feature_exercise

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_model.dto.BreadcrumbItem
import com.devtorres.feature_exercise.nav.ExerciseArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseDetailViewModel @Inject constructor(
    private val breadcrumbsManager: BreadcrumbsManager,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // `MutableStateFlow` reactiva que reemplaza el valor fijo
    private val _exerciseId = MutableStateFlow(ExerciseArgs(savedStateHandle).exerciseId)
    val exerciseId: StateFlow<String> = _exerciseId.asStateFlow()

    val breadcrumbs: StateFlow<Set<BreadcrumbItem>> = breadcrumbsManager.getHistory()

    // Estado de carga
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        Log.d("ExerciseDetailViewModel", "ExerciseId: $exerciseId")
        viewModelScope.launch {
            exerciseId.collect { exerciseId ->
                fetchDetailInfo(exerciseId)
            }
        }
    }

    private fun fetchDetailInfo(exerciseId: String) {
        viewModelScope.launch {
            _isLoading.update { true }

            delay(1000)

            breadcrumbsManager.addItem(
                item = BreadcrumbItem(id = exerciseId, name = "sisoy")
            )
            popUpToBreadcrumbs(exerciseId)

            _isLoading.update { false }
        }
    }

    fun changeExercise(newId: String) {
        if(_exerciseId.value == newId) return

        viewModelScope.launch {
            _exerciseId.update { newId }
        }
    }

    fun clearBreadcrumbs() {
        viewModelScope.launch {
            breadcrumbsManager.clear()
        }
    }

    private fun popUpToBreadcrumbs(breadcrumbsId: String) {
        viewModelScope.launch {
            breadcrumbsManager.popUpTo(breadcrumbsId)
        }
    }
}