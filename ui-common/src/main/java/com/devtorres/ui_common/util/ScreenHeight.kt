package com.devtorres.ui_common.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Altura total de la pantalla en dp (excluye sistema de ventanas) */
@Composable
fun screenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return remember {
        configuration.screenHeightDp.dp
    }
}

/** Altura de la status bar (barra de estado) en dp */
@Composable
fun statusBarHeight(): Dp {
    val density = LocalDensity.current
    val insetPx = WindowInsets.statusBars.getTop(density)
    return remember {
        with(density) { insetPx.toDp() }
    }
}

/** Altura de la navigation bar (barra de navegación) en dp */
@Composable
fun navigationBarHeight(): Dp {
    val density = LocalDensity.current
    val insetPx = WindowInsets.navigationBars.getBottom(density)
    return remember {
        with(density) { insetPx.toDp() }
    }
}

@Composable
fun screenHeightExcludingTopBar(topBarHeight: Dp = 64.dp): Dp {

    val screenHeight = screenHeight()

    return remember {
        screenHeight - topBarHeight
    }
}