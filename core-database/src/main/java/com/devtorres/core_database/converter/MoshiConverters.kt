package com.devtorres.core_database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.devtorres.core_model.enum.MuscleGroup
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class MoshiConverters @Inject constructor(
    private val moshi: Moshi
) {
    // --- Adapter para List<String> ---
    private val stringListAdapter = moshi.adapter<List<String>>(
        Types.newParameterizedType(List::class.java, String::class.java)
    )

    // --- Adapter para List<MuscleGroup> ---
    private val muscleListAdapter = moshi.adapter<List<MuscleGroup>>(
        Types.newParameterizedType(List::class.java, MuscleGroup::class.java)
    )

    // --- Ejemplos de converters ---

    @TypeConverter
    fun fromStringList(value: List<String>): String =
        stringListAdapter.toJson(value)

    @TypeConverter
    fun toStringList(json: String): List<String> =
        stringListAdapter.fromJson(json) ?: emptyList()

    @TypeConverter
    fun fromMuscleGroupList(value: List<MuscleGroup>): String =
        muscleListAdapter.toJson(value)

    @TypeConverter
    fun toMuscleGroupList(json: String): List<MuscleGroup> =
        muscleListAdapter.fromJson(json) ?: emptyList()
}