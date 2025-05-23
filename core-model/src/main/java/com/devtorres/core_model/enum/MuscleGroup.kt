package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class MuscleGroup {
    ALL,

    // Región de la cabeza y cuello
    @Json(name = "neck")            NECK,
    @Json(name = "traps")           TRAPS,

    // Parte superior del torso (pecho y hombros)
    @Json(name = "shoulders")       SHOULDERS,
    @Json(name = "chest")           CHEST,

    // Espalda
    @Json(name = "back")            BACK,
    @Json(name = "lats")            LATS,
    @Json(name = "lower back")      LOWER_BACK,

    // Brazos
    @Json(name = "biceps")          BICEPS,
    @Json(name = "triceps")         TRICEPS,
    @Json(name = "forearms")        FOREARMS,

    // Zona media (core)
    @Json(name = "abs")             ABS,
    @Json(name = "core")            CORE,

    // Caderas y glúteos
    @Json(name = "glutes")          GLUTES,
    @Json(name = "abductors")       ABDUCTORS,
    @Json(name = "adductors")       ADDUCTORS,

    // Piernas
    @Json(name = "quadriceps")      QUADRICEPS,
    @Json(name = "hamstrings")      HAMSTRINGS,
    @Json(name = "calves")          CALVES
}