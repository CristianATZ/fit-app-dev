package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.MuscleGroup
import com.devtorres.ui_common.R

@StringRes
fun MuscleGroup.stringRes(): Int = when (this) {
    MuscleGroup.ALL           -> R.string.muscle_all
    MuscleGroup.CHEST         -> R.string.muscle_chest
    MuscleGroup.BACK          -> R.string.muscle_back
    MuscleGroup.LOWER_BACK    -> R.string.muscle_lower_back
    MuscleGroup.SHOULDERS     -> R.string.muscle_shoulders
    MuscleGroup.CALVES        -> R.string.muscle_calves
    MuscleGroup.FOREARMS      -> R.string.muscle_forearms
    MuscleGroup.ABS           -> R.string.muscle_abs
    MuscleGroup.NECK          -> R.string.muscle_neck
    MuscleGroup.TRAPS         -> R.string.muscle_traps
    MuscleGroup.QUADRICEPS    -> R.string.muscle_quadriceps
    MuscleGroup.HAMSTRINGS    -> R.string.muscle_hamstrings
    MuscleGroup.GLUTES        -> R.string.muscle_glutes
    MuscleGroup.BICEPS        -> R.string.muscle_biceps
    MuscleGroup.TRICEPS       -> R.string.muscle_triceps
    MuscleGroup.LATS          -> R.string.muscle_lats
    MuscleGroup.ABDUCTORS     -> R.string.muscle_abductors
    MuscleGroup.ADDUCTORS     -> R.string.muscle_adductors
    MuscleGroup.CORE          -> R.string.muscle_core
}