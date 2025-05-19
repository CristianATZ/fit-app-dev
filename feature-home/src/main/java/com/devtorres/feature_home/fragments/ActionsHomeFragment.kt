package com.devtorres.feature_home.fragments

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.feature_home.R
import com.devtorres.ui_common.typo.LabelLarge
import com.devtorres.ui_common.typo.TitleLarge
import com.devtorres.ui_common.util.screenHeightExcludingTopBar

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
            .heightIn(min = screenHeightExcludingTopBar())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Card (
                shape = shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                ),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(colorScheme.onBackground.copy(0.5f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    Column {
                        TitleLarge(
                            stringResId = R.string.lblRoutines,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onPrimary
                        )

                        Spacer(Modifier.size(12.dp))

                        LabelLarge(
                            stringResId = R.string.lblRoutinesDescription,
                            textAlign = TextAlign.Justify
                        )
                    }

                    TextButton(
                        onClick = { },
                        shape = shapes.medium,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = colorScheme.onPrimary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ver ejercicios",
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.size(12.dp))

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null
                        )
                    }
                }
            }

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