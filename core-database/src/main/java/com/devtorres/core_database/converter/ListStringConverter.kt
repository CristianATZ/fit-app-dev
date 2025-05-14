package com.devtorres.core_database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ListStringConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<String>? {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)

        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(list: List<String>?): String {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)

        return adapter.toJson(list)
    }
}
