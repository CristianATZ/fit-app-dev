package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.SupplementEntity
import com.devtorres.core_model.SupplementDto

object SupplementDtoToEntityMapper {
    fun asEntity(domain: SupplementDto): SupplementEntity {
        return SupplementEntity(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            brand = domain.brand,
            presentations = domain.presentations,
            flavors = domain.flavors,
            benefits = domain.benefits,
            usage = domain.usage,
            composition = domain.composition,
            sideEffects = domain.sideEffects,
            recommendation = domain.recommendation,
            image = domain.image,
            category = domain.category,
            nutritionalInfo = domain.nutritionalInfo.toMap()
        )
    }
}

fun SupplementDto.asEntity() : SupplementEntity {
    return SupplementDtoToEntityMapper.asEntity(this)
}