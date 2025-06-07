package com.devtorres.core_utils

object Validators {

    /**
     * Valida que un string solo contenga números
     */
    fun isDigitValid(value: String) : Boolean = value.matches(Regex(RegexPatterns.isDigit))
}