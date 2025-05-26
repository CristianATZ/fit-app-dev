package com.devtorres.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devtorres.core_database.entity.EquipmentEntity

@Dao
interface EquipmentDao {

    @Query("SELECT COUNT(*) FROM equipments")
    suspend fun countEquipments(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipments(equipments: List<EquipmentEntity>)

    @Query("SELECT * FROM equipments WHERE id IN (:equipmentIds)")
    suspend fun getEquipmentsByIds(equipmentIds: List<String>): List<EquipmentEntity>

}