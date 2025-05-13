package com.devtorres.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devtorres.core_database.converter.ListStringConverter
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.ExerciseEntity

@Database(
    entities = [
        ExerciseEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    value = [
        ListStringConverter::class
    ]
)
abstract class FitAppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
}