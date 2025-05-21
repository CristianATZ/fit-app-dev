package com.devtorres.feature_exercises.components

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.ui_common.typo.LabelLarge
import kotlinx.coroutines.launch

@Composable
fun MuscleGroupTabRow() {
    val allMuscleGroups = remember { MuscleGroup.entries.toList() }
    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { allMuscleGroups.size }
    )

    var selectedTabIndex by remember { mutableIntStateOf(pagerState.currentPage) }

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
        allMuscleGroups.forEachIndexed { index, muscleGroup ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    // Actualiza el estado del tab
                    selectedTabIndex = index
                    // Y cambia la página del pager con animación
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    LabelLarge(
                        text = muscleGroup.displayName,
                    )
                },
                selectedContentColor = colorScheme.secondary,
                unselectedContentColor = colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
            )
        }
    }
}