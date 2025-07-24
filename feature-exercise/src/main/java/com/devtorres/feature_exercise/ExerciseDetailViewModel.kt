package com.devtorres.feature_exercise

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_domain.exercise.GetExerciseDetailUseCase
import com.devtorres.core_model.ui.BreadcrumbItem
import com.devtorres.core_model.ui.ExerciseDetail
import com.devtorres.feature_exercise.nav.ExerciseArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExerciseDetailViewModel @Inject constructor(
    private val breadcrumbsManager: BreadcrumbsManager,
    private val getExerciseDetailUseCase: GetExerciseDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // `MutableStateFlow` reactiva que reemplaza el valor fijo
    val exerciseId = MutableStateFlow(ExerciseArgs(savedStateHandle).exerciseId)

    val breadcrumbs: StateFlow<Set<BreadcrumbItem>> = breadcrumbsManager.getHistory()

    // Estado de carga
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _exerciseDetail = MutableStateFlow<ExerciseDetail?>(null)
    val exerciseDetail: StateFlow<ExerciseDetail?> = _exerciseDetail.asStateFlow()

    init {
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

            _exerciseDetail.update {
                withContext(Dispatchers.IO) {
                    getExerciseDetailUseCase(exerciseId = exerciseId)
                }
            }

            breadcrumbsManager.addItem(
                item = BreadcrumbItem(id = exerciseId, name = exerciseDetail.value?.name ?: "Error")
            )
            popUpToBreadcrumbs(exerciseId)

            Log.d("ExerciseDetailViewModel", "ExerciseDetail: ${exerciseDetail.value}")
            _isLoading.update { false }
        }
    }

    @MainThread
    fun changeExercise(newId: String) {
        if(exerciseId.value == newId) return

        viewModelScope.launch {
            exerciseId.update { newId }
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