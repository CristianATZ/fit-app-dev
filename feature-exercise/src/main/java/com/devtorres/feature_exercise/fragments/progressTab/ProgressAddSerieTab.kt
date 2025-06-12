package com.devtorres.feature_exercise.fragments.progressTab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.feature_exercise.ExerciseProgressViewModel
import com.devtorres.feature_exercise.ProgressEvent
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.button.SecondaryButton
import com.devtorres.ui_common.button.SecondaryStateButton
import com.devtorres.ui_common.textfield.CustomOutlinedTextField
import com.devtorres.ui_common.typo.HeadLineSmall
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ProgressAddSerieTab(
    exerciseName: String,
    exerciseProgressViewModel: ExerciseProgressViewModel
) {
    val progressFormState by exerciseProgressViewModel.progressStateForm.collectAsStateWithLifecycle()

    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            HeadLineSmall(
                stringResId = R.string.add_serie_title_upper,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            LabelLarge(
                text = stringResource(R.string.add_serie_description, exerciseName),
                modifier = Modifier.alpha(0.5f)
            )

            Spacer(Modifier.size(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // peso
                    CustomOutlinedTextField(
                        value = progressFormState.weight,
                        onValueChange = {  weight ->
                            exerciseProgressViewModel.onEvent(
                                ProgressEvent.OnWeightChange(weight = weight)
                            )
                        },
                        isError = progressFormState.isWeightError,
                        placeholderResId = R.string.placeholder_weight,
                        leadingIcon = Icons.Default.Build,
                        trailingIcon = Icons.Default.Clear,
                        onTrailingClick = {
                            exerciseProgressViewModel.onEvent(
                                ProgressEvent.OnWeightChange(weight = "")
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Number
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorScheme.secondary,
                            focusedContainerColor = colorScheme.background,
                            unfocusedContainerColor = colorScheme.background
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    // repeticiones
                    CustomOutlinedTextField(
                        value = progressFormState.reps,
                        onValueChange = { reps ->
                            exerciseProgressViewModel.onEvent(
                                ProgressEvent.OnRepsChange(reps = reps)
                            )
                        },
                        isError = progressFormState.isRepsError,
                        placeholderResId = R.string.placeholder_reps,
                        leadingIcon = Icons.Default.Repeat,
                        trailingIcon = Icons.Default.Clear,
                        onTrailingClick = {
                            exerciseProgressViewModel.onEvent(
                                ProgressEvent.OnRepsChange(reps = "")
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Number
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorScheme.secondary,
                            focusedContainerColor = colorScheme.background,
                            unfocusedContainerColor = colorScheme.background
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                // notas
                CustomOutlinedTextField(
                    value = progressFormState.notes,
                    onValueChange = { notes ->
                        exerciseProgressViewModel.onEvent(
                            ProgressEvent.OnNotesChange(notes = notes)
                        )
                    },
                    placeholderResId = R.string.placeholder_notes,
                    leadingIcon = Icons.Default.Bookmark,
                    trailingIcon = Icons.Default.Clear,
                    onTrailingClick = {
                        exerciseProgressViewModel.onEvent(
                            ProgressEvent.OnNotesChange(notes = "")
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorScheme.secondary,
                        focusedContainerColor = colorScheme.background,
                        unfocusedContainerColor = colorScheme.background
                    ),
                )
            }

            Spacer(Modifier.size(16.dp))

            SecondaryStateButton(
                stringResId = R.string.btnAdd,
                enabled = !progressFormState.isWeightError &&
                        !progressFormState.isRepsError &&
                        progressFormState.weight.isNotEmpty() &&
                        progressFormState.reps.isNotEmpty(),
                isLoading = progressFormState.isLoading,
                isCompleted = progressFormState.isComplete,
                isError = progressFormState.isError,
                onClick = {
                    exerciseProgressViewModel.onEvent(
                        ProgressEvent.OnAddProgress
                    )
                }
            )
        }
    }
}