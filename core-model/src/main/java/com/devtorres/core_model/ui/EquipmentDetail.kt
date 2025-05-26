package com.devtorres.core_model.ui

data class EquipmentDetail(
    val id:     String,
    val name:   String
) {
    fun getPreviewImageUri() : String {
        return "equipments/${id.lowercase()}"
    }
}
