package com.devtorres.ui_common.tab

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.devtorres.ui_common.typo.LabelLarge

@Composable
fun CustomTabRow(
    modifier: Modifier = Modifier,
    tabList: List<Int>,
    selectedTabIndex: Int,
    onSelectedTab: (Int) -> Unit
) {
    TabRow (
        selectedTabIndex = selectedTabIndex,
        containerColor = colorScheme.surfaceVariant,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = colorScheme.secondary
            )
        },
        modifier = modifier.clip(shapes.medium)
    ) {
        tabList.forEachIndexed { index, tabName ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onSelectedTab(index)
                },
                text = {
                    LabelLarge(
                        text = stringResource(tabName)
                    )
                },
                selectedContentColor = colorScheme.secondary,
                unselectedContentColor = colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
            )
        }
    }
}