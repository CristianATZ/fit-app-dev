package com.devtorres.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devtorres.core_database.converter.ListStringConverter
import com.devtorres.core_database.converter.MapConverter
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.dao.SupplementDao
import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_database.entity.SupplementEntity

@Database(
    entities = [
        ExerciseEntity::class,
        SupplementEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    value = [
        ListStringConverter::class,
        MapConverter::class
    ]
)
abstract class FitAppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun supplementDao(): SupplementDao
}