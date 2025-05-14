package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supplements")
data class SupplementEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val brand: String,
    val presentations: List<String>,    // TypeConverter: List<String> ↔ String
    val flavors: List<String>?,          // TypeConverter: List<String> ↔ String
    val benefits: List<String>,         // TypeConverter: List<String> ↔ String
    val usage: String,
    val composition: String,
    val sideEffects: List<String>,      // TypeConverter: List<String> ↔ String
    val recommendation: String,
    val image: String,
    val category: String,
    val nutritionalInfo: Map<String, String> // TypeConverter: Map<String, String> ↔ JSON String
)
