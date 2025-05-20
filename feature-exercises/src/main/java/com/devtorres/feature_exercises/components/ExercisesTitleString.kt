package com.devtorres.feature_exercises.components

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.devtorres.feature_exercises.R

@Composable
fun exercisesTitleString() : AnnotatedString {
    return buildAnnotatedString {
        append(stringResource(R.string.lblExercisesTitle1))

        withStyle(
            style = SpanStyle(
                color = colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(stringResource(R.string.lblExercisesTitle2))
        }
    }
}