package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class ExerciseCategory {
    ALL,
    @Json(name = "strength")        STRENGTH,
    @Json(name = "cardio")          CARDIO,
    @Json(name = "stretching")      STRETCHING,
    @Json(name = "plyometric")      PLYOMETRIC,
    @Json(name = "strongman")       STRONGMAN,
    @Json(name = "powerlifting")    POWERLIFTING
}

/**
 * Alterna la presencia de [item] en el set, con reglas especiales para ALL:
 * - Si seleccionas ALL → solo ALL.
 * - Si seleccionas otro nivel → elimina ALL, añade o quita el nivel.
 * - Si tras quitar no queda ningún nivel → vuelve a ALL.
 */
fun Set<ExerciseCategory>.addExerciseCategoryFilter(item: ExerciseCategory): Set<ExerciseCategory> =
    when (item) {
        ExerciseCategory.ALL -> setOf(ExerciseCategory.ALL)
        else -> {
            // 1) Partimos de la colección sin ALL
            val withoutAll = this - ExerciseCategory.ALL
            // 2) Alternamos el nivel
            val toggled = if (item in withoutAll) withoutAll - item else withoutAll + item
            // 3) Si queda vacío, retorno ALL; si no, el set toggled
            toggled.ifEmpty { setOf(ExerciseCategory.ALL) }
        }
    }