package com.devtorres.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.devtorres.core_database.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Query("SELECT COUNT(*) FROM exercises")
    suspend fun countExercises(): Int

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: List<ExerciseEntity>)

    @Query("SELECT * FROM exercises")
    suspend fun getExercises(): List<ExerciseEntity>

    @Query("SELECT * FROM exercises WHERE id = :exerciseId")
    suspend fun getExerciseById(exerciseId: String): ExerciseEntity

    @Query("SELECT * FROM exercises WHERE id IN (:exerciseIds)")
    suspend fun getAlternativeNames(exerciseIds: List<String>): List<ExerciseEntity>
}