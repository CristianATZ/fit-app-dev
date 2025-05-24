package com.devtorres.feature_exercises.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.core_model.enum.addEquipmentFilter
import com.devtorres.core_model.enum.addExerciseCategoryFilter
import com.devtorres.core_model.enum.addLevelTypeFilter
import com.devtorres.core_model.enum.addMechanicTypeFilter
import com.devtorres.core_model.enum.addMuscleFilter
import com.devtorres.core_model.ui.ExercisesFilter
import com.devtorres.feature_exercises.ExercisesViewModel
import com.devtorres.feature_exercises.R
import com.devtorres.feature_exercises.components.MuscleGroupTabRow
import com.devtorres.feature_exercises.components.exercisesTitleString
import com.devtorres.finager.core.presentation.components.typo.BodyLarge
import com.devtorres.finager.core.presentation.components.typo.BodySmall
import com.devtorres.ui_common.ListDialogContainer
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.button.SecondaryTextButton
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.textfield.CustomOutlinedTextField
import com.devtorres.ui_common.typo.HeadLineLarge
import com.devtorres.ui_common.typo.LabelLarge
import com.google.accompanist.flowlayout.FlowRow
import java.util.Locale.Category

@Composable
fun ExercisesHeaderFragment(
    exercisesViewModel: ExercisesViewModel
) {

    val filter by exercisesViewModel.filter.collectAsStateWithLifecycle()
    val showFilterDialog by exercisesViewModel.showFilterDialog.collectAsStateWithLifecycle()

    FilterDialog(
        currentFilters = filter,
        showFilterDialog = showFilterDialog,
        onSaveFilters = { newFilters: ExercisesFilter ->
            exercisesViewModel.updateFilter { newFilters }
        },
        onDismiss = {
            exercisesViewModel.showFilterDialog()
        }
    )
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        HeadLineLarge(
            text = exercisesTitleString(),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        BodyLarge(
            stringResId = R.string.lblExercisesTitleDescription,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.5f),
        )

        Column {

            val (query, setQuery) = remember { mutableStateOf("") }
            val keyboardController = LocalSoftwareKeyboardController.current

            MuscleGroupTabRow(
                filter = filter,
                onMuscleSelected = { selected ->
                    exercisesViewModel.updateFilter { copy(selectedMuscles = selected) }
                }
            )

            Spacer(Modifier.size(8.dp))

            CustomOutlinedTextField(
                value = query,
                onValueChange = setQuery,
                placeholderResId = R.string.lblSearchExercise,
                leadingIcon = Icons.Default.Search,
                trailingIcon = Icons.Default.Clear,
                onTrailingClick = {
                    setQuery("")
                    exercisesViewModel.updateFilter { copy(searchQuery = "") }
                    keyboardController?.hide() // Oculta el teclado
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        exercisesViewModel.updateFilter { copy(searchQuery = query) }
                        keyboardController?.hide() // Oculta el teclado
                    }
                )
            )

            Spacer(Modifier.size(12.dp))

            CustomOutlinedButton(
                stringResId = R.string.btnFilter,
                onClick = {
                    exercisesViewModel.showFilterDialog()
                }
            )

            Spacer(Modifier.size(24.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterDialog(
    currentFilters: ExercisesFilter,
    showFilterDialog: Boolean,
    onSaveFilters: (ExercisesFilter) -> Unit,
    onDismiss: () -> Unit
) {

    if(!showFilterDialog) return

    var newFilters by remember {
        mutableStateOf(currentFilters)
    }

    val muscleList = remember { MuscleGroup.entries.toList() }
    val levelTypeList = remember { LevelType.entries.toList() }
    val equipmentTypeList = remember { EquipmentType.entries.toList() }
    val exerciseCategoryList = remember { ExerciseCategory.entries.toList() }
    val mechanicTypeList = remember { MechanicType.entries.toList() }

    ListDialogContainer(
        titleResId = R.string.lblFiltersUpperCase,
        descriptionResId = R.string.lblExercisesFilters,
        onRestartClick = {
            newFilters = currentFilters
        },
        onSaveClick = {
            onSaveFilters(newFilters)
            onDismiss()
        },
        onDismiss = onDismiss
    ) {

        // muscle group chips
        Column {
            LabelLarge(
                stringResId = R.string.lblMuscleGroups,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(0.5f)
            )

            FlowRow(
                mainAxisSpacing = 8.dp
            ) {
                muscleList.forEach { muscleGroup ->
                    FilterChip(
                        selected = muscleGroup in newFilters.selectedMuscles,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = colorScheme.secondary,
                            selectedLabelColor = colorScheme.onSecondary,
                            containerColor = colorScheme.surfaceVariant
                        ),
                        onClick = {
                            // Un único operador de toggle
                            newFilters = newFilters.copy(
                                selectedMuscles = newFilters.selectedMuscles.addMuscleFilter(muscleGroup)
                            )
                        },
                        label = {
                            LabelLarge(
                                text = stringResource(muscleGroup.stringRes())
                            )
                        }
                    )
                }
            }

            SecondaryTextButton(
                stringResId = R.string.btnReset,
                onClick = {
                    newFilters = newFilters.copy(
                        selectedMuscles = newFilters.selectedMuscles.addMuscleFilter(MuscleGroup.ALL)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // level type chips
        Column {
            LabelLarge(
                stringResId = R.string.lblLevelType,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(0.5f)
            )

            FlowRow(
                mainAxisSpacing = 8.dp
            ) {
                levelTypeList.forEach { levelType ->
                    FilterChip(
                        selected = levelType in newFilters.levels,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = colorScheme.secondary,
                            selectedLabelColor = colorScheme.onSecondary,
                            containerColor = colorScheme.surfaceVariant
                        ),
                        onClick = {
                            // Un único operador de toggle
                            newFilters = newFilters.copy(
                                levels = newFilters.levels.addLevelTypeFilter(levelType)
                            )
                        },
                        label = {
                            LabelLarge(
                                text = stringResource(levelType.stringRes())
                            )
                        }
                    )
                }
            }

            SecondaryTextButton(
                stringResId = R.string.btnReset,
                onClick = {
                    newFilters = newFilters.copy(
                        levels = newFilters.levels.addLevelTypeFilter(LevelType.ALL)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // equipment type chips
        Column {
            LabelLarge(
                stringResId = R.string.lblEquipmentType,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(0.5f)
            )

            FlowRow(
                mainAxisSpacing = 8.dp
            ) {
                equipmentTypeList.forEach { equipmentType ->
                    FilterChip(
                        selected = equipmentType in newFilters.equipment,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = colorScheme.secondary,
                            selectedLabelColor = colorScheme.onSecondary,
                            containerColor = colorScheme.surfaceVariant
                        ),
                        onClick = {
                            // Un único operador de toggle
                            newFilters = newFilters.copy(
                                equipment = newFilters.equipment.addEquipmentFilter(equipmentType)
                            )
                        },
                        label = {
                            LabelLarge(
                                text = stringResource(equipmentType.stringRes())
                            )
                        }
                    )
                }
            }

            SecondaryTextButton(
                stringResId = R.string.btnReset,
                onClick = {
                    newFilters = newFilters.copy(
                        equipment = newFilters.equipment.addEquipmentFilter(EquipmentType.ALL)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // mechanic type chips
        Column {
            LabelLarge(
                stringResId = R.string.lblMechanicType,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(0.5f)
            )

            FlowRow(
                mainAxisSpacing = 8.dp
            ) {
                mechanicTypeList.forEach { mechanicType ->
                    FilterChip(
                        selected = mechanicType in newFilters.mechanics,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = colorScheme.secondary,
                            selectedLabelColor = colorScheme.onSecondary,
                            containerColor = colorScheme.surfaceVariant
                        ),
                        onClick = {
                            // Un único operador de toggle
                            newFilters = newFilters.copy(
                                mechanics = newFilters.mechanics.addMechanicTypeFilter(mechanicType)
                            )
                        },
                        label = {
                            LabelLarge(
                                text = stringResource(mechanicType.stringRes())
                            )
                        }
                    )
                }
            }

            SecondaryTextButton(
                stringResId = R.string.btnReset,
                onClick = {
                    newFilters = newFilters.copy(
                        mechanics = newFilters.mechanics.addMechanicTypeFilter(MechanicType.ALL)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // exercise category type chips
        Column {
            LabelLarge(
                stringResId = R.string.lblExerciseCategory,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(0.5f)
            )

            FlowRow(
                mainAxisSpacing = 8.dp
            ) {
                exerciseCategoryList.forEach { exerciseCategory ->
                    FilterChip(
                        selected = exerciseCategory in newFilters.categories,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = colorScheme.secondary,
                            selectedLabelColor = colorScheme.onSecondary,
                            containerColor = colorScheme.surfaceVariant
                        ),
                        onClick = {
                            // Un único operador de toggle
                            newFilters = newFilters.copy(
                                categories = newFilters.categories.addExerciseCategoryFilter(exerciseCategory)
                            )
                        },
                        label = {
                            LabelLarge(
                                text = stringResource(exerciseCategory.stringRes())
                            )
                        }
                    )
                }
            }

            SecondaryTextButton(
                stringResId = R.string.btnReset,
                onClick = {
                    newFilters = newFilters.copy(
                        categories = newFilters.categories.addExerciseCategoryFilter(ExerciseCategory.ALL)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.size(ButtonDefaults.MinHeight + 24.dp))
    }
}