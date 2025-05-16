package com.devtorres.ui_common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun screenHeight(): Dp {
    val configuration = LocalConfiguration.current               // acceso a resolución :contentReference[oaicite:0]{index=0}
    return configuration.screenHeightDp.dp
}

@Composable
fun screenHeightExcludingTopBar(topBarHeight: Dp = 64.dp): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp.dp - topBarHeight
}