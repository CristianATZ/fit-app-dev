package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.ui_common.R

@StringRes
fun EquipmentType.stringRes(): Int = when (this) {
    EquipmentType.BARBELL      -> R.string.equipment_barbell
    EquipmentType.DUMBELL      -> R.string.equipment_dumbbell
    EquipmentType.MACHINE      -> R.string.equipment_machine
    EquipmentType.CABLE        -> R.string.equipment_cable
    EquipmentType.BODY_ONLY    -> R.string.equipment_body_only
    EquipmentType.KATTLELBELL  -> R.string.equipment_kettlebell
    EquipmentType.BAND         -> R.string.equipment_band
    EquipmentType.OTHER        -> R.string.equipment_other
}