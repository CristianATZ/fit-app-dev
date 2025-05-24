package com.devtorres.ui_common.strings

import androidx.annotation.StringRes
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.ui_common.R

@StringRes
fun MechanicType.stringRes(): Int = when (this) {
    MechanicType.ALL            -> R.string.lblAll
    MechanicType.ISOLATION      -> R.string.mechanic_isolation
    MechanicType.COMPOUND       -> R.string.mechanic_compound
}