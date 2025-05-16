package com.devtorres.ui_common.typo

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun HeadLineMedium(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = stringResource(stringResId),
        fontWeight = fontWeight,
        color = color,
        style = typography.headlineLarge, // Usar estilo de encabezado grande
        modifier = modifier
    )
}

@Composable
fun HeadLineMedium(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = color,
        style = typography.headlineLarge, // Usar estilo de encabezado grande
        modifier = modifier
    )
}