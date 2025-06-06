package com.devtorres.core_model.enum

import com.squareup.moshi.Json

enum class EquipmentType {
    ALL,
    @Json(name = "barbell")         BARBELL,
    @Json(name = "dumbbell")        DUMBELL,
    @Json(name = "machine")         MACHINE,
    @Json(name = "cable")           CABLE,
    @Json(name = "body_only")       BODY_ONLY,
    @Json(name = "kattlelbell")     KATTLELBELL,
    @Json(name = "band")            BAND,
    @Json(name = "other")           OTHER
}

/**
 * Alterna la presencia de [item] en el set, con reglas especiales para ALL:
 * - Si seleccionas ALL → solo ALL.
 * - Si seleccionas otro nivel → elimina ALL, añade o quita el nivel.
 * - Si tras quitar no queda ningún nivel → vuelve a ALL.
 */
fun Set<EquipmentType>.addEquipmentFilter(item: EquipmentType): Set<EquipmentType> =
    when (item) {
        EquipmentType.ALL -> setOf(EquipmentType.ALL)
        else -> {
            // 1) Partimos de la colección sin ALL
            val withoutAll = this - EquipmentType.ALL
            // 2) Alternamos el nivel
            val toggled = if (item in withoutAll) withoutAll - item else withoutAll + item
            // 3) Si queda vacío, retorno ALL; si no, el set toggled
            toggled.ifEmpty { setOf(EquipmentType.ALL) }
        }
    }