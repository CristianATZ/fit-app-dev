package com.devtorres.feature_home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.devtorres.feature_home.fragments.ActionsHomeFragment
import com.devtorres.feature_home.fragments.WelcomeHomeFragment
import kotlinx.coroutines.launch

@Composable
fun SubHomeScreen(
    drawerState: DrawerState,
    innerPadding: PaddingValues,
    onNavigateToExercises: () -> Unit,
    onNavigateToSupplements: () -> Unit,
    onNavigateToRoutines: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    LazyColumn (
        state = listState,
        modifier = Modifier
            .padding(innerPadding)
    ) {
        item {
            WelcomeHomeFragment(
                onNavigateToRoutines = onNavigateToRoutines,
                onNavigateToExercises = onNavigateToExercises,
                onNavigateToBottom = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(1)
                    }
                }
            )
        }

        item {
            ActionsHomeFragment(
                onNavigateToExercises = onNavigateToExercises,
                onNavigateToSupplements = onNavigateToSupplements,
                onNavigateToRoutines = onNavigateToRoutines
            )
        }
    }
}