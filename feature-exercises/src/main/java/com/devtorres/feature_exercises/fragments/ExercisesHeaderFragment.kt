package com.devtorres.feature_exercises.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devtorres.feature_exercises.MuscleGroupTabRow
import com.devtorres.feature_exercises.R
import com.devtorres.feature_exercises.components.exercisesTitleString
import com.devtorres.finager.core.presentation.components.typo.BodyLarge
import com.devtorres.ui_common.button.CustomOutlinedButton
import com.devtorres.ui_common.textfield.CustomOutlinedTextField
import com.devtorres.ui_common.typo.HeadLineLarge

@Composable
fun ExercisesHeaderFragment(

) {
    val (search, setSearch) = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        HeadLineLarge(
            text = exercisesTitleString(),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        BodyLarge(
            stringResId = R.string.lblExercisesTitleDescription,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.5f),
        )

        MuscleGroupTabRow()

        Column {
            CustomOutlinedTextField(
                value = search,
                onValueChange = setSearch,
                placeholderResId = R.string.lblSearchExercise,
                leadingIcon = Icons.Default.Search,
                trailingIcon = Icons.Default.Clear,
                onTrailingClick = {
                    setSearch("")
                }
            )

            Spacer(Modifier.size(12.dp))

            CustomOutlinedButton(
                stringResId = R.string.btnFilter,
                onClick = {

                }
            )

            Spacer(Modifier.size(24.dp))
        }
    }
}