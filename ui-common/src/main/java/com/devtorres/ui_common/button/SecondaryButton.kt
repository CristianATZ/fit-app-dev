package com.devtorres.ui_common.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorScheme.secondary,
            contentColor = colorScheme.onSecondary
        ),
        enabled = enabled,
        shape = shape,
        modifier = modifier.fillMaxWidth()
    ) {
        LabelLarge(
            stringResId = stringResId
        )
    }
}

@Composable
fun SecondaryStateButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    isLoading: Boolean = false,
    isCompleted: Boolean = false,
    isError: Boolean = false,
    onClick: () -> Unit
) {
    val colors = when {
        isCompleted -> ButtonDefaults.buttonColors(
            containerColor = Color(0xFF03CEA4),
            contentColor = Color(0xFF000000)
        )
        isError -> ButtonDefaults.buttonColors(
            containerColor = colorScheme.error,
            contentColor = colorScheme.onError
        )
        else -> ButtonDefaults.buttonColors(
            containerColor = colorScheme.secondary,
            contentColor = colorScheme.onSecondary
        )
    }

    Button(
        onClick = {
            if(!isLoading && !isCompleted && !isError) {
                onClick()
            }
        },
        colors = colors,
        enabled = enabled,
        shape = shape,
        modifier = modifier.fillMaxWidth()
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = colorScheme.onSecondary
                )
            }
            isCompleted -> {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = colorScheme.onSecondary
                )
            }
            isError -> {
                Icon(
                    imageVector = Icons.Default.Error,
                    contentDescription = null,
                    tint = colorScheme.onError
                )
            }
            else -> {
                LabelLarge(
                    stringResId = stringResId
                )
            }
        }
    }
}