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

    private val listType = Types.newParameterizedType(List::class.java, String::class.java)
    private val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)

    @TypeConverter
    fun fromJson(value: String?): List<String>? =
        value?.let { adapter.fromJson(it) }

    @TypeConverter
    fun toJson(list: List<String>?): String =
        adapter.toJson(list)
}
