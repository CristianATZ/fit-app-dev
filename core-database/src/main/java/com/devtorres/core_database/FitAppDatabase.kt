package com.devtorres.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devtorres.core_database.converter.Converters
import com.devtorres.core_database.converter.MapConverter
import com.devtorres.core_database.converter.MoshiConverters
import com.devtorres.core_database.dao.EquipmentDao
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.dao.ProgressDao
import com.devtorres.core_database.dao.SupplementDao
import com.devtorres.core_database.entity.EquipmentEntity
import com.devtorres.core_database.entity.ExerciseEntity
import com.devtorres.core_database.entity.ProgressEntity
import com.devtorres.core_database.entity.SupplementEntity


@Database(
    entities = [
        ExerciseEntity::class,
        SupplementEntity::class,
        EquipmentEntity::class,
        ProgressEntity::class
    ],
    version = 2
)
@TypeConverters(
    value = [
        Converters::class,
        MoshiConverters::class,
        MapConverter::class
    ]
)
abstract class FitAppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun supplementDao(): SupplementDao
    abstract fun equipmentDao(): EquipmentDao
    abstract fun progressDao(): ProgressDao

}