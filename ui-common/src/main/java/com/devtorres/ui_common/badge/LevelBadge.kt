package com.devtorres.ui_common.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.enum.LevelType
import com.devtorres.finager.core.presentation.components.typo.BodySmall
import com.devtorres.ui_common.strings.stringRes

@Composable
fun LevelBadge(
    modifier: Modifier = Modifier,
    level: LevelType
) {
    val containerColor = remember {
        when (level) {
            LevelType.ALL          -> Color.Transparent
            LevelType.BEGINNER     -> Color(0xFF03CEA4)
            LevelType.INTERMEDIATE -> Color(0xFFFCEC52)
            LevelType.ADVANCED     -> Color(0xFFBA1F33)
        }
    }

    val contentColor = remember {
        when (level) {
            LevelType.ALL          -> Color.Transparent
            LevelType.BEGINNER     -> Color(0xFF000000)
            LevelType.INTERMEDIATE -> Color(0xFF000000)
            LevelType.ADVANCED     -> Color(0xFFFFFFFF)
        }
    }

    Badge(
        containerColor = containerColor,
        contentColor = contentColor
    ) {
        BodySmall(
            stringResId = level.stringRes(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
    }
}