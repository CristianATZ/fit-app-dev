package com.devtorres.ui_common.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    enabled: Boolean = true,
    fontSize: TextUnit = TextUnit.Unspecified,
    shape: Shape = MaterialTheme.shapes.small,
    onClick: () -> Unit
) {
    val text = stringResource(stringResId)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorScheme.secondary,
            contentColor = colorScheme.onSecondary
        ),
        enabled = enabled,
        shape = shape,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = fontSize
        )
    }
}