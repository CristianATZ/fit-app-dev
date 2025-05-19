package com.devtorres.feature_home.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleLarge

@Composable
fun OptionCard(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int,
    @StringRes descriptionResId: Int,
    @StringRes buttonResId: Int,
    boxIcon: ImageVector,
    cardColors: CardColors,
    textButtonColors: ButtonColors,
    onClick: () -> Unit
) {
    Card (
        shape = shapes.medium,
        colors = cardColors,
        onClick = onClick
    ) {
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colorScheme.onBackground.copy(0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = rememberVectorPainter(boxIcon),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Column {
                TitleLarge(
                    stringResId = titleResId,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.size(12.dp))

                LabelLarge(
                    stringResId = descriptionResId,
                    textAlign = TextAlign.Justify
                )
            }

            TextButton(
                onClick = onClick,
                shape = shapes.medium,
                colors = textButtonColors,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(buttonResId),
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.size(12.dp))

                Icon(
                    painter = rememberVectorPainter(Icons.AutoMirrored.Filled.ArrowForward),
                    contentDescription = null
                )
            }
        }
    }
}