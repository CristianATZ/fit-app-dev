package com.devtorres.core_model.dto

import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import com.devtorres.core_model.enum.MuscleGroup
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExerciseResponse(
    @field:Json(name = "exercises")
    val exerciseDtos: List<ExerciseDto>
)

@JsonClass(generateAdapter = true)
data class ExerciseDto(
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "force")
    val force: ForceType,

    @field:Json(name = "level")
    val level: LevelType,

    @field:Json(name = "mechanic")
    val mechanic: MechanicType,

    @field:Json(name = "equipment")
    val equipment: EquipmentType,

    @field:Json(name = "primaryMuscles")
    val primaryMuscles: List<MuscleGroup>,

    @field:Json(name = "secondaryMuscles")
    val secondaryMuscles: List<MuscleGroup>,

    @field:Json(name = "instructions")
    val instructions: List<String>,

    @field:Json(name = "category")
    val category: ExerciseCategory,

    @field:Json(name = "exerciseImages")
    val exerciseImages: List<String>,

    @field:Json(name = "equipmentIds")
    val equipmentIds: List<String>,

    @field:Json(name = "alternative")
    val alternative: List<String>
)
