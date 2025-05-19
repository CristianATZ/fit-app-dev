package com.devtorres.feature_home.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.BatterySaver
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devtorres.feature_home.R
import com.devtorres.feature_home.components.OptionCard
import com.devtorres.ui_common.util.screenHeightExcludingTopBar

@Composable
internal fun ActionsHomeFragment(
    onNavigateToExercises: () -> Unit,
    onNavigateToSupplements: () -> Unit,
    onNavigateToRoutines: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.surfaceVariant)
            .heightIn(min = screenHeightExcludingTopBar())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            OptionCard(
                titleResId = R.string.lblRoutinesUpperCase,
                descriptionResId = R.string.lblRoutinesDescription,
                buttonResId = R.string.btnExploreRoutines,
                boxIcon = Icons.Default.Bookmark,
                cardColors = CardDefaults.cardColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                ),
                textButtonColors = ButtonDefaults.textButtonColors(
                    contentColor = colorScheme.onPrimary
                ),
                onClick = onNavigateToRoutines,
            )

            OptionCard(
                titleResId = R.string.lblExercisesUpperCase,
                descriptionResId = R.string.lblExercisesDescription,
                buttonResId = R.string.btnExploreExercises,
                boxIcon = Icons.Default.BarChart,
                cardColors = CardDefaults.cardColors(
                    containerColor = colorScheme.secondary,
                    contentColor = colorScheme.onSecondary
                ),
                textButtonColors = ButtonDefaults.textButtonColors(
                    contentColor = colorScheme.onSecondary
                ),
                onClick = onNavigateToExercises,
            )

            OptionCard(
                titleResId = R.string.lblSupplementsUpperCase,
                descriptionResId = R.string.lblSupplementsDescription,
                buttonResId = R.string.btnExploreSupplements,
                boxIcon = Icons.Default.BatterySaver,
                cardColors = CardDefaults.cardColors(
                    containerColor = colorScheme.tertiary,
                    contentColor = colorScheme.onTertiary
                ),
                textButtonColors = ButtonDefaults.textButtonColors(
                    contentColor = colorScheme.onTertiary
                ),
                onClick = onNavigateToSupplements,
            )
        }
    }
}