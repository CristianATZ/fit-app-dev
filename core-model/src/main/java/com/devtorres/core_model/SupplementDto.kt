package com.devtorres.core_model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SupplementResponse(
    @field:Json(name = "supplements")
    val supplementDtos: List<SupplementDto>
)

@JsonClass(generateAdapter = true)
data class SupplementDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "brand")
    val brand: String,
    @field:Json(name = "presentations")
    val presentations: List<String>,
    @field:Json(name = "flavors")
    val flavors: List<String>?,
    @field:Json(name = "benefits")
    val benefits: List<String>,
    @field:Json(name = "usage")
    val usage: String,
    @field:Json(name = "composition")
    val composition: String,
    @field:Json(name = "sideEffects")
    val sideEffects: List<String>,
    @field:Json(name = "recommendation")
    val recommendation: String,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "category")
    val category: String,
    @field:Json(name = "nutritionalInfo")
    val nutritionalInfo: NutritionalInfo
)

@JsonClass(generateAdapter = true)
data class NutritionalInfo(
    val servingSize: String? = null,
    val servingsPerContainer: Int? = null,
    val calories: String? = null,
    val protein: String? = null,
    val carbs: String? = null,
    val fat: String? = null,
    val sugar: String? = null,
    val sodium: String? = null,
    val cholesterol: String? = null,
    val calcium: String? = null,
    val potassium: String? = null,
    // Campos específicos de algunos suplementos:
    val bcaas: String? = null,
    val leucine: String? = null,
    val isoleucine: String? = null,
    val valine: String? = null,
    val electrolytes: String? = null,
    val caffeine: String? = null,
    val betaAlanine: String? = null,
    val creatineNitrate: String? = null,
    // …otros según necesidad…
)
