package com.devtorres.finager.core.presentation.components.typo

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
fun BodyLarge(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Unspecified,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        style = typography.bodyLarge, // Usar estilo de encabezado pequeño
        modifier = modifier
    )
}

@Composable
fun BodyLarge(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    textAlign: TextAlign = TextAlign.Unspecified,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    val text = stringResource(id = stringResId)

    Text(
        text = text,
        fontWeight = fontWeight,
        textAlign = textAlign,
        color = color,
        style = typography.bodyLarge,
        modifier = modifier
    )
}