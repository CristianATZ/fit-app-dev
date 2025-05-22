package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class MuscleGroup {
    ALL,
    @Json(name = "chest")           CHEST,
    @Json(name = "back")            BACK,
    @Json(name = "lower back")      LOWER_BACK,
    @Json(name = "shoulders")       SHOULDERS,
    @Json(name = "arms")            ARMS,
    @Json(name = "legs")            LEGS,
    @Json(name = "calves")          CALVES,
    @Json(name = "forearms")        FOREARMS,
    @Json(name = "abs")             ABS,
    @Json(name = "neck")            NECK,
    @Json(name = "traps")           TRAPS,
    @Json(name = "quadriceps")      QUADRICEPS,
    @Json(name = "hamstrings")      HAMSTRINGS,
    @Json(name = "glutes")          GLUTES,
    @Json(name = "biceps")          BICEPS,
    @Json(name = "triceps")         TRICEPS,
    @Json(name = "lats")            LATS,
    @Json(name = "abductors")       ABDUCTORS,
    @Json(name = "adductors")       ADDUCTORS,
    @Json(name = "core")            CORE
}
