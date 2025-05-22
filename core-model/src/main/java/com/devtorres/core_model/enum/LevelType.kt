package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class LevelType {
    @Json(name = "beginner")        BEGINNER,
    @Json(name = "intermediate")    INTERMEDIATE,
    @Json(name = "advanced")        ADVANCED
}