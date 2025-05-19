package com.devtorres.ui_common

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun fitProString(
    upperCase: Boolean = true
) : AnnotatedString {

    val fitString = stringResource(R.string.lblFit)
    val proString = stringResource(R.string.lblPro)

    return buildAnnotatedString {
        withStyle(style = SpanStyle(color = colorScheme.primary, fontWeight = FontWeight.Bold)) {
            append(
                if(upperCase) fitString.uppercase()
                else fitString
            )
        }
        withStyle(style = SpanStyle(color = colorScheme.onBackground, fontWeight = FontWeight.Bold)) {
            append(
                if(upperCase) proString.uppercase()
                else proString
            )
        }
    }
}