package com.devtorres.feature_home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.fitProString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    drawerState: DrawerState,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = fitProString(upperCase = false)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.background,
                titleContentColor = colorScheme.onBackground
            ),
            actions = {
                MenuIconButton(
                    onClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )
            }
        )

        HorizontalDivider(
            color = colorScheme.outline,
            thickness = 1.dp
        )
    }
}

@Composable
private fun MenuIconButton(
    onClick: () -> Unit
) {
    OutlinedIconButton(
        colors = IconButtonDefaults.outlinedIconButtonColors(

        ),
        border = BorderStroke(
            width = 1.dp,
            colorScheme.outline
        ),
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null
        )
    }
}
