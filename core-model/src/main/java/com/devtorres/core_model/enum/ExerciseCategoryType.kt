package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class ExerciseCategoryType {
    @Json(name = "strength")        STRENGTH,
    @Json(name = "cardio")          CARDIO,
    @Json(name = "stretching")      STRETCHING,
    @Json(name = "plyometric")      PLYOMETRIC,
    @Json(name = "strongman")       STRONGMAN,
    @Json(name = "powerlifting")    POWERLIFTING
}