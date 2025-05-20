package com.devtorres.feature_exercises

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.feature_exercises.components.exercisesTitleString
import com.devtorres.feature_exercises.fragments.ExercisesHeaderFragment
import com.devtorres.finager.core.presentation.components.typo.BodyLarge
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.textfield.CustomOutlinedTextField
import com.devtorres.ui_common.typo.HeadLineLarge
import com.devtorres.ui_common.typo.LabelLarge
import kotlinx.coroutines.launch

@Composable
fun ExercisesScreen(
    exercisesViewModel: ExercisesViewModel,
    innerPadding: PaddingValues,
    onNavigateToExercise: () -> Unit
) {
    val exercises by exercisesViewModel.exerciseList.collectAsStateWithLifecycle()
    val isLoading by exercisesViewModel.isLoading.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(innerPadding)
            .padding(24.dp)
    ) {
        item {
            ExercisesHeaderFragment()
        }

        if(isLoading) {
            item {
                CircularProgressIndicator(
                    color = colorScheme.secondary
                )
            }
        } else {
            items(exercises) {
                Text(
                    text = it.name
                )
            }
        }
    }
}


@Composable
fun MuscleGroupTabRow(

) {
    val allMuscleGroups by remember {
        mutableStateOf(
            MuscleGroup.entries.toList()
        )
    }

    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { allMuscleGroups.size }
    )

    // **Estado que controla el tab seleccionado**
    var selectedTabIndex by remember { mutableIntStateOf(0) }

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
