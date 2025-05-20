package com.devtorres.core_model

data class ExerciseUI(
    val name: String,
    val level: String,
    val equipment: String,
    val category: String,
    val primaryMuscles: List<String>,
    val secondaryMuscles: List<String>,
    val exerciseImages: List<String>
)
