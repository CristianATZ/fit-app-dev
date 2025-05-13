package com.devtorres.core_database.entity.mapper

interface EntityMapper<Entity, Domain> {

    fun asEntity(domain: Domain): Entity

    fun asDomain(entity: Entity): Domain
}