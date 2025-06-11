package com.devtorres.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devtorres.core_database.entity.ProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {

    /**
     * Obtiene todos los progreso de la base de datos.
     *
     * @property progress Objeto [ProgressEntity] reprensentado un progreso
     *
     * @return Lista de objetos ProgressEntity.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgress(progress: ProgressEntity)

    /**
     * Elimina un progreso de la base de datos.
     *
     * @property progressId Identificador del progreso a eliminar.
     */
    @Query("""
        DELETE 
        FROM progress
        WHERE id = :progressId
    """)
    suspend fun deleteProgress(progressId: String)

    /**
     * Obtiene todos los progreso de la base de datos.
     *
     * @property date Fecha de inicio del progreso (convertiro en Long).
     *
     * @return Lista de objetos ProgressEntity.
     */
    @Query("""
        SELECT * 
        FROM progress
        WHERE date >= :date
        AND exerciseId = :exerciseId
    """)
    suspend fun getAllProgressList(
        date: Long,
        exerciseId: String
    ) : List<ProgressEntity>
}