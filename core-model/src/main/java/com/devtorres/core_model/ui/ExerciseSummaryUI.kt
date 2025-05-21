package com.devtorres.core_model.ui

data class ExerciseSummaryUI(
    val id: String,
    val name: String,
    val level: String,
    val equipment: String,
    val category: String,
    val primaryMuscles: List<String>,
    val secondaryMuscles: List<String>,
    val exerciseImages: List<String>
) {
    fun getPreviewImageUri() : String {
        return "exercises/${id.lowercase()}/${exerciseImages[0]}"
    }

    fun name() : String = name.uppercase()
    fun equipment() : String = equipment.replaceFirstChar { it.uppercase() }
    fun level() : String = level.replaceFirstChar { it.uppercase() }
    fun category() : String = category.replaceFirstChar { it.uppercase() }
    fun primaryMuscles() : List<String> = primaryMuscles.map { list -> list.replaceFirstChar { it.uppercase() } }
    fun secondaryMuscles() : List<String> = secondaryMuscles.map { list -> list.replaceFirstChar { it.uppercase() } }
}
