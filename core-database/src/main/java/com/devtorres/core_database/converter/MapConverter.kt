package com.devtorres.core_database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class MapConverter @Inject constructor(
    private val moshi: Moshi
) {
    @TypeConverter
    fun fromMap(map: Map<String, String>?): String {
        val mapType = Types.newParameterizedType(
            Map::class.java, String::class.java, String::class.java
        )
        val adapter: JsonAdapter<Map<String, String>> = moshi.adapter(mapType)

        return adapter.toJson(map ?: emptyMap())
    }

    @TypeConverter
    fun toMap(json: String?): Map<String, String> {
        val mapType = Types.newParameterizedType(
            Map::class.java, String::class.java, String::class.java
        )
        val adapter: JsonAdapter<Map<String, String>> = moshi.adapter(mapType)

        return json?.let { adapter.fromJson(it) } ?: emptyMap()
    }
}
