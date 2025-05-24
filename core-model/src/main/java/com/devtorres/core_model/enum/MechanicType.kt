package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class MechanicType {
    ALL,
    @Json(name = "compound")    COMPOUND,
    @Json(name = "isolation")   ISOLATION
}

/**
 * Alterna la presencia de [item] en el set, con reglas especiales para ALL:
 * - Si seleccionas ALL → solo ALL.
 * - Si seleccionas otro nivel → elimina ALL, añade o quita el nivel.
 * - Si tras quitar no queda ningún nivel → vuelve a ALL.
 */
fun Set<MechanicType>.addMechanicTypeFilter(item: MechanicType): Set<MechanicType> =
    when (item) {
        MechanicType.ALL -> setOf(MechanicType.ALL)
        else -> {
            // 1) Partimos de la colección sin ALL
            val withoutAll = this - MechanicType.ALL
            // 2) Alternamos el nivel
            val toggled = if (item in withoutAll) withoutAll - item else withoutAll + item
            // 3) Si queda vacío, retorno ALL; si no, el set toggled
            toggled.ifEmpty { setOf(MechanicType.ALL) }
        }
    }