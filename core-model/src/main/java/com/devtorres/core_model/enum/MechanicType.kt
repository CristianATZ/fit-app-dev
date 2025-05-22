package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class MechanicType {
    @Json(name = "compound")    COMPOUND,
    @Json(name = "isolation")   ISOLATION
}