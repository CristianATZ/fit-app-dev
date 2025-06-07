package com.devtorres.feature_exercises.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.ui.ExercisesFilter
import com.devtorres.feature_exercises.ExercisesFilterDialog
import com.devtorres.feature_exercises.ExercisesViewModel
import com.devtorres.feature_exercises.R
import com.devtorres.feature_exercises.components.MuscleGroupTabRow
import com.devtorres.feature_exercises.components.exercisesTitleString
import com.devtorres.finager.core.presentation.components.typo.BodyLarge
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.textfield.CustomOutlinedTextField
import com.devtorres.ui_common.typo.HeadLineLarge

@Composable
fun ExercisesHeaderFragment(
    exercisesViewModel: ExercisesViewModel
) {

    val filter by exercisesViewModel.filter.collectAsStateWithLifecycle()
    val showFilterDialog by exercisesViewModel.showFilterDialog.collectAsStateWithLifecycle()

    ExercisesFilterDialog(
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
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorScheme.secondary
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