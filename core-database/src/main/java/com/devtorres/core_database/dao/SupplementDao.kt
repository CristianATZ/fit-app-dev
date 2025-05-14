package com.devtorres.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.devtorres.core_database.entity.SupplementEntity

@Dao
interface SupplementDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSupplements(supplements: List<SupplementEntity>)
}