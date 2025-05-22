package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class EquipmentType {
    @Json(name = "barbell")         BARBELL,
    @Json(name = "dumbbell")        DUMBELL,
    @Json(name = "machine")         MACHINE,
    @Json(name = "cable")           CABLE,
    @Json(name = "body_only")       BODY_ONLY,
    @Json(name = "kattlelbell")     KATTLELBELL,
    @Json(name = "band")            BAND,
    @Json(name = "other")           OTHER
}