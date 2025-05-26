package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipments")
data class EquipmentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val imageUri: String
)