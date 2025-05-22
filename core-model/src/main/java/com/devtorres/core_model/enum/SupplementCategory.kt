package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class SupplementCategory {
    @Json(name = "protein")         PROTEIN,
    @Json(name = "amino_acid")      AMINO_ACIDS,
    @Json(name = "creatine")        CREATINE,
    @Json(name = "pre_workout")     PREWORKOUT,
    @Json(name = "post_workout")    POSTWORKOUT,
    @Json(name = "vitamin")         VITAMINS,
    @Json(name = "muscle_mass")     MUSCLE_MASS,
    @Json(name = "fat_loss")        FAT_LOSS,
    @Json(name = "preworkout")      ENERGY,
    @Json(name = "recovery")        RECOVERY,
    @Json(name = "other")           OTHER
}