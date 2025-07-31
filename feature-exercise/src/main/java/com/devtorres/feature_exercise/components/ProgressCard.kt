package com.devtorres.feature_exercise.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.ui.ProgressSummary
import com.devtorres.core_utils.StringUtils
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.LabelSmall
import com.devtorres.ui_common.typo.TitleSmall

@Composable
fun ProgressCard(
    progressSummary: ProgressSummary,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val date = remember(progressSummary.date) {
        StringUtils.getRelativeDateString(progressSummary.date, context)
    }

    val time = remember(progressSummary.date) {
        StringUtils.getTimeString24h(progressSummary.date)
    }

    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.background
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.alpha(0.5f)
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = null
                    )

                    Spacer(Modifier.size(8.dp))

                    LabelSmall(
                        text = date,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.size(12.dp))

                    LabelSmall(
                        text = time,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row {
                    // peso
                    TitleSmall(
                        text = stringResource(R.string.lblKg, progressSummary.weight.toString()),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.size(12.dp))

                    // repeticiones
                    TitleSmall(
                        text = stringResource(R.string.lblReps, progressSummary.reps.toString()),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.size(24.dp))

                    LabelLarge(
                        text = stringResource(R.string.lblRmAprox, progressSummary.oneRm.toString()),
                        modifier = Modifier.alpha(0.5f)
                    )
                }
            }

            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = colorScheme.error
                ),
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DeleteOutline,
                    contentDescription = null
                )
            }
        }
    }
}