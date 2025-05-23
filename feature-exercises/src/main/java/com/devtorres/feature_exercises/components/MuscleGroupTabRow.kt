package com.devtorres.feature_exercises.components

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

    val selectedTabIndex = muscleGroups.indexOfFirst { it in filter.selectedMuscles }

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 8.dp,
        containerColor = colorScheme.surfaceVariant,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = colorScheme.secondary
            )
        },
        modifier = Modifier.clip(shapes.medium)
    ) {
        muscleGroups.forEachIndexed { index, muscleGroup ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        onMuscleSelected(setOf(muscleGroup))
                    },
                    text = {
                        LabelLarge(
                            text = stringResource(muscleGroup.stringRes())
                        )
                    },
                    selectedContentColor = colorScheme.secondary,
                    unselectedContentColor = colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
        }
    }
}