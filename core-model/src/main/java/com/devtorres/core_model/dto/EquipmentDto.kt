package com.devtorres.core_model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EquipmentResponse(
    @field:Json(name = "equipments")
    val equipmentsDtos: List<EquipmentDto>
)

@JsonClass(generateAdapter = true)
data class EquipmentDto(
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "imageUri")
    val imageUri: String
)
