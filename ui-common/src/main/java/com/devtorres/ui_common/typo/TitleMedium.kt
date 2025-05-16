package com.devtorres.ui_common.typo

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
fun TitleMedium(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        style = typography.titleMedium, // Usar estilo de encabezado pequeño
        modifier = modifier
    )
}

@Composable
fun TitleMedium(
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
        style = typography.titleMedium,
        modifier = modifier
    )
}