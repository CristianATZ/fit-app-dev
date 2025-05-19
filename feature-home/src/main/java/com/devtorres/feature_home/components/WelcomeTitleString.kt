package com.devtorres.feature_home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.devtorres.feature_home.R
import com.devtorres.ui_common.fitProString

@Composable
internal fun welcomeTitleString() : AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(stringResource(R.string.lblHomeTitle))
        }
        append(" ")
        append(fitProString())
    }
}