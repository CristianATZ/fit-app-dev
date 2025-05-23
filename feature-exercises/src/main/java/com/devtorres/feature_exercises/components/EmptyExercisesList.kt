package com.devtorres.feature_exercises.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.feature_exercises.R
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun EmptyExercisesList() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        LabelLarge(
            stringResId = R.string.lblEmptyExercisesList,
            textAlign = TextAlign.Center,
            modifier = Modifier.alpha(0.5f)
        )
    }
}
