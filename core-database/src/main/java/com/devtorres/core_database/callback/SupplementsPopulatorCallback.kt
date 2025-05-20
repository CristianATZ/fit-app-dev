package com.devtorres.core_database.callback

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devtorres.core_database.dao.SupplementDao
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_model.dto.SupplementResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


class SupplementsPopulatorCallback @Inject constructor(
    @ApplicationContext private val context: Context,
    private val provider: Provider<SupplementDao>,
    private val moshi: Moshi
) : RoomDatabase.Callback() {

    private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        scope.launch(Dispatchers.IO) {
            val supplementDao = provider.get()

            Log.d("SupplementsPopulatorCallback", "onCreate: Inicio")

            val supplementsJsonRaw = context.assets.open("supplements.json")
                .bufferedReader()
                .use { it.readText() }

            Log.d("SupplementsPopulatorCallback", "onCreate: Informacion parceada")

            val adapter: JsonAdapter<SupplementResponse> = moshi.adapter(SupplementResponse::class.java)

            val wrapper = adapter.fromJson(supplementsJsonRaw)

            val supplements = wrapper?.supplementDtos ?: emptyList()

            Log.d("SupplementsPopulatorCallback", "onCreate: $supplements")

            supplementDao.insertSupplements(
                supplements = supplements.map { it.asEntity() }
            )
        }
    }
}