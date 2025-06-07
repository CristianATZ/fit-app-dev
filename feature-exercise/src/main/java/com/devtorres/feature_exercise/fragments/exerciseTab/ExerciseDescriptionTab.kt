package com.devtorres.feature_exercise.fragments.exerciseTab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.ui.ExerciseDetail
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.ImageTitleCard
import com.devtorres.ui_common.badge.ErrorBadge
import com.devtorres.ui_common.badge.SecondaryBadge
import com.devtorres.ui_common.badge.SurfaceBadge
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.typo.TitleMedium
import com.google.accompanist.flowlayout.FlowRow

@Composable
internal fun ExerciseDescriptionTab(
    details: ExerciseDetail,
    navigateToExerciseVariant: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        // musculos principales
        Column {
            TitleMedium(
                stringResId = R.string.lblPrimaryMusclesUpperCase,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 8.dp
            ) {
                details.primaryMuscles.forEach { muscle ->
                    SecondaryBadge(
                        label = stringResource(muscle.stringRes())
                    )
                }
            }
        }

        // musculos secundarios
        Column {
            TitleMedium(
                stringResId = R.string.lblSecondaryMusclesUpperCase,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            if(details.secondaryMuscles.isNotEmpty()) {
                FlowRow(
                    mainAxisSpacing = 8.dp,
                    crossAxisSpacing = 8.dp
                ) {
                    details.secondaryMuscles.forEach { muscle ->
                        SurfaceBadge(
                            label = stringResource(muscle.stringRes())
                        )
                    }
                }
            } else {
                ErrorBadge(
                    label = stringResource(R.string.empty_muscle_list)
                )
            }
        }

        // ejercicios alternativos
        Column {
            TitleMedium(
                stringResId = R.string.lblAlternativeExercisesUpperCase,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 8.dp
            ) {
                details.alternative.forEach { exercise ->
                    ImageTitleCard(
                        folderPath = exercise.getPreviewImageUri(),
                        title = exercise.name,
                        onClick = {
                            navigateToExerciseVariant(exercise.id)
                        }
                    )
                }
            }
        }
    }
}

