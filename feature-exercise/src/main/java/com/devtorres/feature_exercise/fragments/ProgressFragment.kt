package com.devtorres.feature_exercise.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devtorres.feature_exercise.InformationCard
import com.devtorres.feature_exercise.R

@Composable
fun ProgressFragment() {
    Column {
        Row {
            InformationCard(
                titleResId = R.string.lblTotalSeriesUpperCase,
                description = stringResource(R.string.lblTotalSeriesDescription),
                text = "0",
                modifier = Modifier.weight(0.5f)
            )

            Spacer(Modifier.size(12.dp))

            InformationCard(
                titleResId = R.string.lblRmEstimatedUpperCase,
                description = stringResource(R.string.lblRmEstimatedDescription, 1, 1),
                text = "0 kg",
                modifier = Modifier.weight(0.5f)
            )
        }

        Spacer(Modifier.size(12.dp))

        InformationCard(
            titleResId = R.string.lblRecentlyProgressUpperCase,
            description = stringResource(R.string.lblRecentlyProgressDescription),
            text = "0%",
            modifier = Modifier.fillMaxWidth()
        )
    }
}