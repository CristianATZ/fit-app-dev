package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.LevelType
import com.devtorres.ui_common.R

@StringRes
fun LevelType.stringRes(): Int = when (this) {
    LevelType.BEGINNER     -> R.string.level_beginner
    LevelType.INTERMEDIATE -> R.string.level_intermediate
    LevelType.ADVANCED     -> R.string.level_advanced
}