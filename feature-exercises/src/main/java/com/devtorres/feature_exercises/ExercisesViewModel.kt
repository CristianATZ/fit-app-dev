package com.devtorres.feature_exercises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtorres.core_domain.GetExercisesUseCase
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.core_model.ui.ExerciseSummaryUI
import com.devtorres.core_model.ui.ExercisesFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val getExercisesUseCase: GetExercisesUseCase
) : ViewModel() {

    // Estado de filtros
    private val _filter = MutableStateFlow(
        ExercisesFilter(
            selectedMuscles = setOf(MuscleGroup.ALL),
            levels = setOf(LevelType.ALL),
            equipment = setOf(EquipmentType.ALL),
            mechanics = setOf(MechanicType.ALL),
            forces = setOf(ForceType.ALL),
            categories = setOf(ExerciseCategory.ALL)
        )
    )
    val filter: StateFlow<ExercisesFilter> = _filter.asStateFlow()

    // Estado de carga
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Estado de lista de ejercicios
    private val _exerciseList = MutableStateFlow<List<ExerciseSummaryUI>>(emptyList())

    private val _showFilterDialog = MutableStateFlow(false)
    val showFilterDialog: StateFlow<Boolean> = _showFilterDialog.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val filteredExercises: StateFlow<List<ExerciseSummaryUI>> =
        _filter.flatMapLatest { filter ->
             _isLoading.update { true }

            flow {
                delay(1000)

                val result = _exerciseList.value.filter { exercise ->
                    exercise.name.contains(filter.searchQuery, ignoreCase = true) &&
                            (filter.levels.any { it == LevelType.ALL } || exercise.level in filter.levels) &&
                            (filter.mechanics.any { it == MechanicType.ALL } || exercise.mechanic in filter.mechanics) &&
                            (filter.forces.any { it == ForceType.ALL } || exercise.force in filter.forces) &&
                            (filter.equipment.any { it == EquipmentType.ALL } || exercise.equipment in filter.equipment) &&
                            (filter.categories.any { it == ExerciseCategory.ALL } || exercise.category in filter.categories) &&
                                (filter.selectedMuscles.any { it == MuscleGroup.ALL } ||
                                exercise.primaryMuscles.any { it in filter.selectedMuscles } ||
                                exercise.secondaryMuscles.any { it in filter.selectedMuscles })
                }

                emit(result)
            }.onCompletion { _isLoading.update { false } }
        }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            _exerciseList.value = withContext(Dispatchers.IO) {
                getExercisesUseCase()
            }
        }
    }

    /** Actualiza un filtro individual */
    fun updateFilter(update: ExercisesFilter.() -> ExercisesFilter) {
        viewModelScope.launch {
            _filter.update(update)
        }
    }

    /** Abre el dialog para los filtros*/
    fun showFilterDialog() {
        viewModelScope.launch {
            _showFilterDialog.value = !_showFilterDialog.value
        }
    }
}