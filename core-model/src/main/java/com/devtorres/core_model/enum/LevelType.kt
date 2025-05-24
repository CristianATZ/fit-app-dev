package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class LevelType {
    ALL,
    @Json(name = "beginner")        BEGINNER,
    @Json(name = "intermediate")    INTERMEDIATE,
    @Json(name = "advanced")        ADVANCED
}

/**
 * Alterna la presencia de [item] en el set, con reglas especiales para ALL:
 * - Si seleccionas ALL → solo ALL.
 * - Si seleccionas otro nivel → elimina ALL, añade o quita el nivel.
 * - Si tras quitar no queda ningún nivel → vuelve a ALL.
 */
fun Set<LevelType>.addLevelTypeFilter(item: LevelType): Set<LevelType> =
    when (item) {
        LevelType.ALL -> setOf(LevelType.ALL)
        else -> {
            // 1) Partimos de la colección sin ALL
            val withoutAll = this - LevelType.ALL
            // 2) Alternamos el nivel
            val toggled = if (item in withoutAll) withoutAll - item else withoutAll + item
            // 3) Si queda vacío, retorno ALL; si no, el set toggled
            toggled.ifEmpty { setOf(LevelType.ALL) }
        }
    }