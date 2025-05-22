package com.devtorres.core_database.callback

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_model.dto.ExerciseResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ExercisesPopulatorCallback @Inject constructor(
    @ApplicationContext private val context: Context,
    private val provider: Provider<ExerciseDao>,
    private val moshi: Moshi
) : RoomDatabase.Callback() {

    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        scope.launch {
            val exerciseDao = provider.get()

            if(exerciseDao.countExercises() == 0) {
                Log.d("ExercisesPopulatorCallback", "onCreate: Inicio")

                val exercisesJsonRaw = context.assets.open("exercises.json")
                    .bufferedReader()
                    .use { it.readText() }

                Log.d("ExercisesPopulatorCallback", "onCreate: Informacion parceada")

                val wrapper = moshi.adapter(ExerciseResponse::class.java)
                    .fromJson(exercisesJsonRaw)

                val exercises = wrapper?.exerciseDtos ?: emptyList()

                Log.d("ExercisesPopulatorCallback", "onCreate: $exercises")

                exerciseDao.insertExercises(
                    exercises = exercises.map { it.asEntity() }
                )
            }
        }
    }
}