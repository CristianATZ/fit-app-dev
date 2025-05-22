package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class ForceType {
    @Json(name = "push")        PUSH,
    @Json(name = "pull")        PULL,
    @Json(name = "static")      STATIC
}