package com.devtorres.core_data.mapper

interface EntityMapper<Entity, Domain> {

    fun asEntity(domain: Domain): Entity

    fun asDomain(entity: Entity): Domain
}