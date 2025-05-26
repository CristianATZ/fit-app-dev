package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.ForceType
import com.devtorres.ui_common.R

@StringRes
fun ForceType.stringRes() : Int = when (this) {
    ForceType.ALL       -> R.string.lblAll
    ForceType.PULL      -> R.string.force_pull
    ForceType.PUSH      -> R.string.force_push
    ForceType.STATIC    -> R.string.force_static
}