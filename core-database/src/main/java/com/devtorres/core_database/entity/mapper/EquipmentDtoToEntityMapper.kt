package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.EquipmentEntity
import com.devtorres.core_model.dto.EquipmentDto

object EquipmentDtoToEntityMapper {

    fun asEntity(domain: EquipmentDto): EquipmentEntity {
        return EquipmentEntity(
            id = domain.id,
            name = domain.name,
            imageUri = domain.imageUri
        )
    }
}

fun EquipmentDto.asEntity() : EquipmentEntity {
    return EquipmentDtoToEntityMapper.asEntity(this)
}