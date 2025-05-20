package com.devtorres.feature_exercises

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(

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



}