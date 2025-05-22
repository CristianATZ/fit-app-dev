package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.ExerciseCategoryType
import com.devtorres.ui_common.R

@StringRes
fun ExerciseCategoryType.stringRes(): Int = when (this) {
    ExerciseCategoryType.STRENGTH     -> R.string.category_strength
    ExerciseCategoryType.CARDIO       -> R.string.category_cardio
    ExerciseCategoryType.STRETCHING   -> R.string.category_stretching
    ExerciseCategoryType.PLYOMETRIC   -> R.string.category_plyometric
    ExerciseCategoryType.STRONGMAN    -> R.string.category_strongman
    ExerciseCategoryType.POWERLIFTING -> R.string.category_powerlifting
}