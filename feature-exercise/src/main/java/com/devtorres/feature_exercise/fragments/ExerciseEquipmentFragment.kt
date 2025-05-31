package com.devtorres.feature_exercise.fragments

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devtorres.core_model.ui.EquipmentDetail
import com.devtorres.ui_common.ImageTitleCard
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ExerciseEquiptmentFragment(
    equipments: List<EquipmentDetail>
) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
    ) {
        equipments.forEach { equipment ->
            Log.d("imageURi", equipment.getPreviewImageUri())
            ImageTitleCard(
                folderPath = equipment.getPreviewImageUri(),
                title = equipment.name,
                onClick = {
                    // abrir dialogo

                }
            )
        }
    }
}