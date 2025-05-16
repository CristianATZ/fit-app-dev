package com.devtorres.ui_common.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomOutlinedButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    enabled: Boolean = true,
    fontSize: TextUnit = TextUnit.Unspecified,
    shape: Shape = MaterialTheme.shapes.small,
    onClick: () -> Unit
) {
    val text = stringResource(stringResId)

    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colorScheme.surface,
            contentColor = colorScheme.onSurface
        ),
        enabled = enabled,
        shape = shape,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = fontSize
        )
    }
}