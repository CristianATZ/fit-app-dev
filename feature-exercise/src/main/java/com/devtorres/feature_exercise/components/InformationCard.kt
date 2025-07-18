package com.devtorres.feature_exercise.components

import androidx.annotation.StringRes
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleLarge
import com.devtorres.ui_common.typo.TitleMedium

@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int,
    color: Color = Color.Unspecified,
    description: String,
    text: String
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
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            TitleMedium(
                stringResId = titleResId,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(8.dp))

            TitleLarge(
                text = text,
                color = color,
                fontWeight = FontWeight.Bold
            )

            LabelLarge(
                text = description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.alpha(0.5f)
            )
        }
    }
}