package com.devtorres.ui_common.typo

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LabelSmall(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        style = typography.labelSmall, // Usar estilo de encabezado pequeño
        modifier = modifier
    )
}

@Composable
fun LabelSmall(
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
        style = typography.labelSmall,
        modifier = modifier
    )
}