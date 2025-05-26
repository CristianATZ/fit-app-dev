package com.devtorres.ui_common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.dto.BreadcrumbItem
import com.devtorres.finager.core.presentation.components.typo.BodySmall

@Composable
fun BreadcrumbCard(
    modifier: Modifier,
    exerciseId: String,
    breadcrumb: BreadcrumbItem,
    onClickItem: () -> Unit,
    isLoading: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InputChip(
            selected = exerciseId == breadcrumb.id,
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = colorScheme.secondary,
                selectedLabelColor = colorScheme.onSecondary,
                containerColor = colorScheme.outline
            ),
            onClick = onClickItem,
            enabled = !isLoading,
            label = {
                BodySmall(
                    text = breadcrumb.name,
                    modifier = Modifier
                        .alpha(
                            if (exerciseId == breadcrumb.id) 1f else 0.5f
                        )
                )
            }
        )

        Spacer(Modifier.size(8.dp))
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .alpha(0.5f)
        )
        Spacer(Modifier.size(8.dp))
    }
}