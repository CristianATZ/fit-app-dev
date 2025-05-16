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

/**
 * Composable que muestra un texto en un estilo de encabezado pequeño,
 * donde el texto se obtiene a partir de un recurso de cadena.
 *
 * @param modifier Modificador opcional para personalizar la UI del componente.
 * @param stringResId Identificador del recurso de cadena que se mostrará.
 * @param color Color del texto o deja el por defecto de Material
 * @param fontWeight Peso de la fuente, por defecto es `FontWeight.Normal`.
 */
@Composable
fun HeadLineSmall(
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
        style = typography.headlineSmall,
        modifier = modifier
    )
}

/**
 * Composable que muestra un texto en un estilo de encabezado pequeño,
 * donde el texto es proporcionado directamente como un `String`.
 *
 * @param modifier Modificador opcional para personalizar la UI del componente.
 * @param text Texto que se mostrará directamente en el componente.
 * @param color Color del texto o deja el por defecto de Material
 * @param fontWeight Peso de la fuente, por defecto es `FontWeight.Normal`.
 */
@Composable
fun HeadLineSmall(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Unspecified,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        textAlign = textAlign,
        color = color,
        style = typography.headlineSmall, // Usar estilo de encabezado pequeño
        modifier = modifier
    )
}