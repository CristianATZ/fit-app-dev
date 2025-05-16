package com.devtorres.ui_common

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    actions: @Composable () -> Unit = {}
) {
    val context = LocalContext.current
    val window = (context as Activity).window
    val statusBarColor = colorScheme.background

    DisposableEffect(Unit) {
        window.statusBarColor = statusBarColor.toArgb()
        onDispose { /* opcional: restaurar color original */ }
    }

    Column {
        TopAppBar(
            title = { Text("Inicio") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.background,
                titleContentColor = colorScheme.onBackground
            )
        )

        HorizontalDivider(
            color = colorScheme.outline,
            thickness = 1.dp
        )
    }
}