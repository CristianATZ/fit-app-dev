package com.devtorres.ui_common.textfield

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.devtorres.ui_common.typo.LabelLarge

/**
 * Composable que crea un campo de texto estilizado con bordes resaltados (OutlinedTextField).
 *
 * @param modifier Modificador para aplicar estilos y configuraciones externas.
 * @param value El texto actual en el campo de texto.
 * @param onValueChange Lambda que se invoca al cambiar el valor del texto.
 * @param placeholderResId ID del recurso de texto que se muestra como texto de marcador (placeholder).
 * @param leadingIcon Composable opcional para mostrar un icono al inicio del campo.
 * @param trailingIcon Composable opcional para mostrar un icono al final del campo (solo si el valor no está vacío).
 * @param keyboardOptions Opciones del teclado virtual, como tipo de entrada.
 * @param keyboardActions Acciones personalizadas para el teclado, como enviar o siguiente.
 */
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderResId: Int,
    leadingIcon: ImageVector,
    isError: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    trailingIcon: ImageVector,
    onTrailingClick: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = null,
        isError = isError,
        placeholder = {
            LabelLarge(
                stringResId = placeholderResId,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        textStyle = TextStyle(
            fontSize = typography.labelLarge.fontSize
        ),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
            )
        },
        trailingIcon = {
            if(value.isNotEmpty()) {
                IconButton(
                    onClick = onTrailingClick
                ) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null
                    )
                }
            }
        },
        colors = colors,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        shape = shapes.small,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
    )
}