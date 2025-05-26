package com.devtorres.core_model.ui

data class ExerciseAlternative(
    val id:     String,
    val name:   String
) {
    fun getPreviewImageUri() : String {
        return "exercises/${id.lowercase()}/0.jpg"
    }
}
