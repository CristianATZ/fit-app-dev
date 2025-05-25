package com.devtorres.feature_exercise

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.devtorres.feature_exercise.nav.ExerciseArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val exerciseId = ExerciseArgs(savedStateHandle).exerciseId

    init {
        Log.d("ExerciseDetailViewModel", "ExerciseId: $exerciseId")
    }

}