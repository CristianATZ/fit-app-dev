package com.devtorres.ui_common.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ErrorButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    elevation: ButtonElevation? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorScheme.error,
            contentColor = colorScheme.onError
        ),
        enabled = enabled,
        shape = shape,
        elevation = elevation ?: ButtonDefaults.buttonElevation(),
        modifier = modifier.fillMaxWidth()
    ) {
        LabelLarge(
            stringResId = stringResId
        )
    }
}