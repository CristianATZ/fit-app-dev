package com.devtorres.ui_common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devtorres.ui_common.button.SecondaryButton
import com.devtorres.ui_common.button.SecondaryTextButton
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleMedium

@Composable
fun ListDialogContainer(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int,
    @StringRes descriptionResId: Int,
    enabledButton: Boolean = true,
    enabledRestartButton: Boolean = true,
    onRestartClick: () -> Unit,
    onSaveClick: () -> Unit,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Surface {
            Box {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    HeaderTitle(
                        titleResId = titleResId,
                        descriptionResId = descriptionResId,
                        onDismiss = onDismiss
                    )

                    content.invoke()
                }

                TopElevationBox(
                    elevation = 4.dp,
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Surface {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                SecondaryTextButton(
                                    stringResId = R.string.btnRestart,
                                    enabled = enabledRestartButton,
                                    onClick = onRestartClick
                                )

                                SecondaryButton (
                                    stringResId = R.string.btnSave,
                                    shape = shapes.small,
                                    onClick = {
                                        if(enabledButton) {
                                            onSaveClick()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopElevationBox(
    elevation: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        // Contenido principal
        content()
        // Caja que simula la sombra en la parte superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(elevation)
                .align(Alignment.TopCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.2f)
                        )
                    )
                )
        )
    }
}

@Composable
private fun HeaderTitle(
    @StringRes titleResId: Int,
    @StringRes descriptionResId: Int,
    onDismiss: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TitleMedium(
                stringResId = titleResId,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = onDismiss
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
        }

        LabelLarge(
            stringResId = descriptionResId,
            modifier = Modifier.alpha(0.5f)
        )
    }

    HorizontalDivider(
        color = colorScheme.outline
    )
}