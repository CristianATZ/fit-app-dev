package com.devtorres.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id: String,
    val name: String,
    val force: String,
    val level: String,
    val mechanic: String,
    val equipment: String,
    val primaryMuscles: List<String>,
    val secondaryMuscles: List<String>,
    val instructions: List<String>,
    val category: String,
    val exerciseImages: List<String>,
    val equipmentIds: List<String>,
    val alternative: List<String>
)
