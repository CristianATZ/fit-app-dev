package com.devtorres.ui_common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.core_model.ui.ExerciseSummaryUI
import com.devtorres.ui_common.badge.SurfaceBadge
import com.devtorres.ui_common.badge.SecondaryBadge
import com.devtorres.ui_common.button.CustomOutlinedIconButton
import com.devtorres.ui_common.button.SecondaryButton
import com.devtorres.ui_common.image.AsyncImageLoader
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleMedium
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ExerciseCard(
    exercise: ExerciseSummaryUI,
    onNavigateToExercise: () -> Unit
) {
    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            AsyncImageLoader(
                folderPath = exercise.getPreviewImageUri(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                TitleMedium(
                    text = exercise.name.uppercase(),
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.size(8.dp))
                
                ExerciseBasicInformation(
                    equipment = exercise.equipment,
                    level = exercise.level,
                    category = exercise.category
                )

                Spacer(Modifier.size(16.dp))
                
                ExerciseBadges(
                    primaryMuscles = exercise.primaryMuscles,
                    secondaryMuscles = exercise.secondaryMuscles
                )

                Spacer(Modifier.size(16.dp))
                
                Row {
                    SecondaryButton(
                        stringResId = R.string.btnDetails,
                        onClick = onNavigateToExercise,
                        modifier = Modifier.weight(0.8f)
                    )

                    Spacer(Modifier.size(8.dp))

                    CustomOutlinedIconButton(
                        imageVector = Icons.Default.Share,
                        shape = shapes.small,
                        onClick = {

                        },
                        modifier = Modifier.weight(0.2f)
                    )
                }
            }
        }


    }
}

@Composable
private fun ExerciseBadges(
    primaryMuscles: List<MuscleGroup>,
    secondaryMuscles: List<MuscleGroup>
) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        primaryMuscles.forEach { muscle ->
            SecondaryBadge(
                label = stringResource(muscle.stringRes())
            )
        }

        secondaryMuscles.forEach { muscle ->
            SurfaceBadge(
                label = stringResource(muscle.stringRes())
            )
        }
    }
}

@Composable
private fun ExerciseBasicInformation(
    equipment: EquipmentType,
    level: LevelType,
    category: ExerciseCategory
) {
    LabelLarge(
        text = stringResource(
            R.string.lblExerciseInfoRow,
            stringResource(equipment.stringRes()),
            stringResource(level.stringRes()),
            stringResource(category.stringRes())
        ),
        modifier = Modifier.alpha(0.5f)
    )
}
