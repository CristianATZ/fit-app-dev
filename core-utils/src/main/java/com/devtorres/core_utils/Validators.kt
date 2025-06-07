package com.devtorres.core_utils

object Validators {

    /**
     * Valida que un valor sea un número positivo
     */
    fun isWeightValid(value: String) : Boolean {
        if(value.isEmpty()) return true

        return value.matches(Regex(RegexPatterns.IS_NUMERIC)) &&
                value.toDoubleOrNull()?.let { it in 0.0..1000.0 } == true
    }

    /**
     * Valida que un valor sea un número entero positivo
     */
    fun isRepsValid(value: String) : Boolean {
        if(value.isEmpty()) return true

        return value.matches(Regex(RegexPatterns.IS_DIGIT)) &&
                value.toIntOrNull()?.let { it in 0..100 } == true
    }
}