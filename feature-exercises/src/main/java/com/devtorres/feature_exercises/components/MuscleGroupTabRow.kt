package com.devtorres.feature_exercises.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.core_model.ui.ExercisesFilter
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun MuscleGroupTabRow(
    filter: ExercisesFilter,
    onMuscleSelected: (Set<MuscleGroup>) -> Unit
) {
    val muscleGroups = remember { MuscleGroup.entries.toList() }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(muscleGroups) { muscleGroup ->
            FilterChip(
                selected = muscleGroup in filter.selectedMuscles,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = colorScheme.secondary,
                    selectedLabelColor = colorScheme.onSecondary,
                    containerColor = colorScheme.surfaceVariant
                ),
                onClick = {
                    onMuscleSelected(setOf(muscleGroup))
                },
                label = {
                    LabelLarge(
                        text = stringResource(muscleGroup.stringRes())
                    )
                }
            )
        }
    }
}