package com.devtorres.feature_exercise.fragments.progressTab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.devtorres.feature_exercise.R
import com.devtorres.ui_common.typo.HeadLineSmall
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ProgressHistoricalTab(
    exerciseName: String
) {
    OutlinedCard (
        colors = CardDefaults.outlinedCardColors(
            containerColor = colorScheme.surface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = colorScheme.outline
        ),
        shape = shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            HeadLineSmall(
                stringResId = R.string.historical_title_upper,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            LabelLarge(
                text = stringResource(R.string.historical_description, exerciseName),
                modifier = Modifier.alpha(0.5f)
            )
        }
    }
}