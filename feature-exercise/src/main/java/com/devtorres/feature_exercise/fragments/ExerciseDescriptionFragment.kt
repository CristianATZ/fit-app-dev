package com.devtorres.feature_exercise.fragments

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.ui.ExerciseDetail
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.badge.SecondaryBadge
import com.devtorres.ui_common.badge.SurfaceBadge
import com.devtorres.ui_common.image.AsyncImageLoader
import com.devtorres.ui_common.strings.stringRes
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleMedium
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ExerciseDescriptionFragment(
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
                    OutlinedCard (
                        colors = CardDefaults.outlinedCardColors(
                            containerColor = colorScheme.surface
                        ),
                        onClick = {
                            navigateToExerciseVariant(exercise.id)
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = colorScheme.outline
                        ),
                        shape = shapes.medium
                    ) {
                        Column(
                            modifier = Modifier
                                .width(175.dp)
                                .heightIn(min = 175.dp)
                        ) {
                            AsyncImageLoader(
                                folderPath = exercise.getPreviewImageUri(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(125.dp)
                            )

                            LabelLarge(
                                text = exercise.name,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}