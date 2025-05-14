package com.devtorres.core_database.entity.mapper

import com.devtorres.core_database.entity.SupplementEntity
import com.devtorres.core_model.Supplement

object SupplementEntityMapper : EntityMapper<SupplementEntity, Supplement> {
    override fun asEntity(domain: Supplement): SupplementEntity {
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

    override fun asDomain(entity: SupplementEntity): Supplement {
        return Supplement(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            brand = entity.brand,
            presentations = entity.presentations,
            flavors = entity.flavors,
            benefits = entity.benefits,
            usage = entity.usage,
            composition = entity.composition,
            sideEffects = entity.sideEffects,
            recommendation = entity.recommendation,
            image = entity.image,
            category = entity.category,
            nutritionalInfo = entity.nutritionalInfo.toNutritionalInfo()
        )
    }

}

fun Supplement.asEntity() : SupplementEntity {
    return SupplementEntityMapper.asEntity(this)
}

fun SupplementEntity.asDomain() : Supplement {
    return SupplementEntityMapper.asDomain(this)
}