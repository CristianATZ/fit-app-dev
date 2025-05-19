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

/**
 * Una tarjeta de opción que muestra un ícono, un título, una descripción y un botón de acción.
 *
 * @param modifier             Modificador de Compose para personalizar la apariencia y el comportamiento.
 * @param titleResId           Recurso de cadena para el título principal de la tarjeta.
 * @param descriptionResId     Recurso de cadena para la descripción detallada de la tarjeta.
 * @param buttonResId          Recurso de cadena para el texto del botón de acción.
 * @param boxIcon              Vector de imagen que se mostrará en el círculo superior de la tarjeta.
 * @param cardColors           Colores que se aplican al fondo y al contenido de la [Card].
 * @param textButtonColors     Colores que se aplican al botón de texto dentro de la tarjeta.
 * @param onClick              Lambda que se ejecuta cuando se pulsa la tarjeta o el botón interno.
 *
 */
@Composable
internal fun OptionCard(
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
            BoxIcon(
                icon = boxIcon
            )

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

/**
 * Composable que renderiza un ícono dentro de un contenedor circular con fondo semitransparente.
 *
 * @param modifier  Modificador de Compose para ajustar tamaño, posición, etc.
 * @param icon      Vector de imagen que se mostrará en el centro del círculo.
 *
 * Esta función crea un [Box] con forma de círculo (`CircleShape`) y un color de fondo
 * semitransparente basado en el color `onBackground` del tema. Dentro de él, dibuja
 * el ícono provisto con un padding interno de 8.dp para que quede centrado y con espacio.
 *
 */
@Composable
private fun BoxIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(colorScheme.onBackground.copy(0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = rememberVectorPainter(icon),
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
    }
}