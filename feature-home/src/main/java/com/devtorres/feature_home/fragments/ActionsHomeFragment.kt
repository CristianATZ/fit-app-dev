package com.devtorres.feature_home.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.util.screenHeight

@Composable
fun ActionsHomeFragment(
    onNavigateToExercises: () -> Unit,
    onNavigateToSupplements: () -> Unit,
    onNavigateToRoutines: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.surfaceVariant)
            .heightIn(min = screenHeight())
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")
            Text("hola")

        }
    }
}