package com.devtorres.ui_common.button

import androidx.annotation.StringRes
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun SecondaryTextButton(
    @StringRes stringResId: Int,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    TextButton(
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        content = {
            LabelLarge(
                stringResId = stringResId,
                fontWeight = FontWeight.Normal
            )
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = modifier
    )
}