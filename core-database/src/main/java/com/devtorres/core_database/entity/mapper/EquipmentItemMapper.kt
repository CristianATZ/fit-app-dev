package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.EquipmentEntity
import com.devtorres.core_model.ui.EquipmentDetail

object EquipmentItemMapper {

    fun asDomain(domain: List<EquipmentEntity>) : List<EquipmentDetail> {
        return domain.map {
            EquipmentDetail(
                id = it.id,
                name = it.name,
                imageUri = it.imageUri
            )
        }
    }
}

fun List<EquipmentEntity>.asDomain() : List<EquipmentDetail> {
    return EquipmentItemMapper.asDomain(this)
}