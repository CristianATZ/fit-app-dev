package com.devtorres.finager.core.presentation.components.typo

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BodySmall(
    modifier: Modifier = Modifier,
    text: String,
    overflow: TextOverflow = TextOverflow.Clip,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        overflow = overflow,
        color = color,
        style = typography.bodySmall, // Usar estilo de encabezado pequeño
        modifier = modifier
    )
}

@Composable
fun BodySmall(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    val text = stringResource(id = stringResId)

    Text(
        text = text,
        fontWeight = fontWeight,
        color = color,
        style = typography.bodySmall,
        modifier = modifier
    )
}