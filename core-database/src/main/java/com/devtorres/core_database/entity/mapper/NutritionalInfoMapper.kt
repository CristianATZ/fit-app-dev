package com.devtorres.core_database.entity.mapper

import com.devtorres.core_model.NutritionalInfo

internal fun Map<String, String>.toNutritionalInfo(): NutritionalInfo {
    return NutritionalInfo(
        servingSize = this["servingSize"],
        servingsPerContainer = this["servingsPerContainer"]?.toIntOrNull(),
        calories = this["calories"],
        protein = this["protein"],
        carbs = this["carbs"],
        fat = this["fat"],
        sugar = this["sugar"],
        sodium = this["sodium"],
        cholesterol = this["cholesterol"],
        calcium = this["calcium"],
        potassium = this["potassium"],
        bcaas = this["bcaas"],
        leucine = this["leucine"],
        isoleucine = this["isoleucine"],
        valine = this["valine"],
        electrolytes = this["electrolytes"],
        caffeine = this["caffeine"],
        betaAlanine = this["betaAlanine"],
        creatineNitrate = this["creatineNitrate"]
        // …otros campos según tu definición…
    )
}

internal fun NutritionalInfo.toMap(): Map<String, String> {
    val map = mutableMapOf<String, String>()

    servingSize?.let { map["servingSize"] = it }
    servingsPerContainer?.let { map["servingsPerContainer"] = it.toString() }
    calories?.let { map["calories"] = it }
    protein?.let { map["protein"] = it }
    carbs?.let { map["carbs"] = it }
    fat?.let { map["fat"] = it }
    sugar?.let { map["sugar"] = it }
    sodium?.let { map["sodium"] = it }
    cholesterol?.let { map["cholesterol"] = it }
    calcium?.let { map["calcium"] = it }
    potassium?.let { map["potassium"] = it }
    bcaas?.let { map["bcaas"] = it }
    leucine?.let { map["leucine"] = it }
    isoleucine?.let { map["isoleucine"] = it }
    valine?.let { map["valine"] = it }
    electrolytes?.let { map["electrolytes"] = it }
    caffeine?.let { map["caffeine"] = it }
    betaAlanine?.let { map["betaAlanine"] = it }
    creatineNitrate?.let { map["creatineNitrate"] = it }
    // Agrega más campos según sea necesario

    return map
}
