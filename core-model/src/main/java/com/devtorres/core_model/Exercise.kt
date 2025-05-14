package com.devtorres.core_model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExerciseResponse(
    @field:Json(name = "exercises")
    val exercises: List<Exercise>
)

@JsonClass(generateAdapter = true)
data class Exercise(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "force")
    val force: String,
    @field:Json(name = "level")
    val level: String,
    @field:Json(name = "mechanic")
    val mechanic: String,
    @field:Json(name = "equipment")
    val equipment: String,
    @field:Json(name = "primaryMuscles")
    val primaryMuscles: List<String>,
    @field:Json(name = "secondaryMuscles")
    val secondaryMuscles: List<String>,
    @field:Json(name = "instructions")
    val instructions: List<String>,
    @field:Json(name = "category")
    val category: String,
    @field:Json(name = "exerciseImages")
    val exerciseImages: List<String>,
    @field:Json(name = "equipmentIds")
    val equipmentIds: List<String>,
    @field:Json(name = "alternative")
    val alternative: List<String>
)
