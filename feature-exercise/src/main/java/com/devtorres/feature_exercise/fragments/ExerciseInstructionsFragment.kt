package com.devtorres.feature_exercise.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun ExerciseInstructionsFragment(
    instructions: List<String>
) {
    Column {
        instructions.forEachIndexed { index, instruction ->
            LabelLarge(
                text = "${index+1}. $instruction",
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            )
        }
    }
}