package com.devtorres.feature_home.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.feature_home.R
import com.devtorres.feature_home.components.welcomeTitleString
import com.devtorres.finager.core.presentation.components.typo.BodyLarge
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.button.CustomOutlinedIconButton
import com.devtorres.ui_common.button.PrimaryButton
import com.devtorres.ui_common.typo.HeadLineLarge
import com.devtorres.ui_common.util.screenHeightExcludingTopBar

@Composable
fun WelcomeHomeFragment(
    onNavigateToRoutines: () -> Unit,
    onNavigateToExercises: () -> Unit,
    onNavigateToBottom: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .height(screenHeightExcludingTopBar()),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .matchParentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadLineLarge(
                text = welcomeTitleString(),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.size(24.dp))

            BodyLarge(
                stringResId = R.string.lblHomeTitleDescription,
                textAlign = TextAlign.Center,
                modifier = Modifier.alpha(0.5f)
            )

            Spacer(Modifier.size(32.dp))

            Column {
                PrimaryButton(
                    stringResId = R.string.btnStartNow,
                    onClick = onNavigateToRoutines,
                )

                CustomOutlinedButton(
                    stringResId = R.string.btnExploreExercises,
                    onClick = onNavigateToExercises
                )
            }
        }

        CustomOutlinedIconButton(
            imageVector = Icons.Default.ArrowDropDown,
            onClick = onNavigateToBottom,
            modifier = Modifier.padding(24.dp)
        )
    }
}