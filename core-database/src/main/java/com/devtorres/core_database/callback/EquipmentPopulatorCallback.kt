package com.devtorres.core_database.callback

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devtorres.core_database.dao.EquipmentDao
import com.devtorres.core_database.entity.mapper.asEntity
import com.devtorres.core_model.dto.EquipmentResponse
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class EquipmentPopulatorCallback @Inject constructor(
    @ApplicationContext private val context: Context,
    private val provider: Provider<EquipmentDao>,
    private val moshi: Moshi
) : RoomDatabase.Callback() {
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        scope.launch {
            val equipmentDao = provider.get()

            if(equipmentDao.countEquipments() == 0) {
                Log.d("EquipmentPopulatorCallback", "onCreate: Inicio")

                val equipmentsJsonRaw = context.assets.open("equipments.json")
                    .bufferedReader()
                    .use { it.readText() }

                Log.d("EquipmentPopulatorCallback", "onCreate: Informacion parceada")

                val wrapper = moshi.adapter(EquipmentResponse::class.java)
                    .fromJson(equipmentsJsonRaw)

                val equipments = wrapper?.equipmentsDtos ?: emptyList()

                Log.d("EquipmentPopulatorCallback", "onCreate: $equipments")

                equipmentDao.insertEquipments(
                    equipments = equipments.map { it.asEntity() }
                )
            }
        }
    }
}