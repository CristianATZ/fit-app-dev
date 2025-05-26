package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class ForceType {
    ALL,
    @Json(name = "push")        PUSH,
    @Json(name = "pull")        PULL,
    @Json(name = "static")      STATIC
}

/**
 * Alterna la presencia de [item] en el set, con reglas especiales para ALL:
 * - Si seleccionas ALL → solo ALL.
 * - Si seleccionas otro nivel → elimina ALL, añade o quita el nivel.
 * - Si tras quitar no queda ningún nivel → vuelve a ALL.
 */
fun Set<ForceType>.addForceFilter(item: ForceType): Set<ForceType> {
    when (item) {
        ForceType.ALL -> return setOf(ForceType.ALL)
        else -> {
            // 1) Partimos de la colección sin ALL
            val withoutAll = this - ForceType.ALL
            // 2) Alternamos el nivel
            val toggled = if (item in withoutAll) withoutAll - item else withoutAll + item
            // 3) Si queda vacío, retorno ALL; si no, el set toggled
            return toggled.ifEmpty { setOf(ForceType.ALL) }
        }
    }
}