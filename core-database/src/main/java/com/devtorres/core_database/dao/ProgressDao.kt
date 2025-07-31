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
        ORDER BY date DESC
    """)
    fun getAllProgressList(
        date: Long,
        exerciseId: String
    ) : Flow<List<ProgressEntity>>

    @Query("""
        SELECT COUNT(*)
        FROM progress
        WHERE exerciseId = :exerciseId
    """)
    fun getTotalProgressCount(exerciseId: String) : Flow<Int>

    @Query("""
        SELECT * FROM progress
        WHERE exerciseId = :exerciseId
        ORDER BY oneRm DESC
        LIMIT 1
    """)
    fun getMaxProgressOneRm(exerciseId: String): Flow<ProgressEntity?>

    @Query("""
        SELECT oneRm FROM progress 
        WHERE exerciseId = :exerciseId 
        ORDER BY date DESC 
        LIMIT 2
    """)
    fun getLastTwoProgress(exerciseId: String): Flow<List<Int>>

}