package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.ui_common.R

@StringRes
fun ExerciseCategory.stringRes(): Int = when (this) {
    ExerciseCategory.ALL           -> R.string.lblAll
    ExerciseCategory.STRENGTH     -> R.string.category_strength
    ExerciseCategory.CARDIO       -> R.string.category_cardio
    ExerciseCategory.STRETCHING   -> R.string.category_stretching
    ExerciseCategory.PLYOMETRIC   -> R.string.category_plyometric
    ExerciseCategory.STRONGMAN    -> R.string.category_strongman
    ExerciseCategory.POWERLIFTING -> R.string.category_powerlifting
}