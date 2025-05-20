package com.devtorres.feature_exercises

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_domain.GetExercisesUseCase
import com.devtorres.core_model.ui.ExerciseSummaryUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val getExercisesUseCase: GetExercisesUseCase
) : ViewModel() {

    // 1. Estado de carga
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // 2. Mensajes de error/toast: un SharedFlow para eventos únicos
    private val _toastMessage = MutableSharedFlow<String?>(
        replay = 0,             // no reemite al suscriptor
        extraBufferCapacity = 1 // buffer para lanzar sin suspender
    )
    val toastMessage: SharedFlow<String?> = _toastMessage.asSharedFlow()

    // Estado de lista de ejercicios
    private val _exerciseList = MutableStateFlow<List<ExerciseSummaryUI>>(emptyList())
    val exerciseList: StateFlow<List<ExerciseSummaryUI>> = _exerciseList.asStateFlow()

    init {
        fetchAllExercises()
    }

    private fun fetchAllExercises() {
        viewModelScope.launch {
            _isLoading.value = true

            delay(1000)

            try {
                val exercises = getExercisesUseCase()
                _exerciseList.value = exercises
            } catch (e: Exception) {
                _toastMessage.emit(e.message)
            } finally {
                _isLoading.value = false
            }
        }
    }
}