package com.devtorres.ui_common.textfield

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.typo.LabelLarge

/**
 * Composable que crea un campo de texto estilizado con bordes resaltados (OutlinedTextField).
 *
 * @param modifier Modificador para aplicar estilos y configuraciones externas.
 * @param value El texto actual en el campo de texto.
 * @param onValueChange Lambda que se invoca al cambiar el valor del texto.
 * @param labelResId ID del recurso de texto que se muestra como etiqueta (label).
 * @param placeholderResId ID del recurso de texto que se muestra como texto de marcador (placeholder).
 * @param leadingIcon Composable opcional para mostrar un icono al inicio del campo.
 * @param trailingIcon Composable opcional para mostrar un icono al final del campo (solo si el valor no está vacío).
 * @param isError Indica si el campo está en estado de error.
 * @param visualTransformation Transformación visual aplicada al texto (por ejemplo, para contraseñas).
 * @param keyboardOptions Opciones del teclado virtual, como tipo de entrada.
 * @param keyboardActions Acciones personalizadas para el teclado, como enviar o siguiente.
 * @param shape Forma del borde del campo de texto.
 * @param singleLine Indica si el campo de texto debe limitarse a una sola línea.
 */
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderResId: Int,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onTrailingClick: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = null,
        placeholder = {
            LabelLarge(
                stringResId = placeholderResId
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
        shape = shapes.small,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
    )
}