package com.devtorres.core_database.converter

import androidx.room.TypeConverter
import com.devtorres.core_model.enum.EquipmentType
import com.devtorres.core_model.enum.ExerciseCategory
import com.devtorres.core_model.enum.ForceType
import com.devtorres.core_model.enum.LevelType
import com.devtorres.core_model.enum.MechanicType
import java.time.LocalDateTime
import java.time.ZoneOffset

object Converters {

    // converters para LOCAL DATE TIME
    @TypeConverter fun fromLocalDateTime(value: LocalDateTime): Long =
        value.toInstant(ZoneOffset.UTC).toEpochMilli()
    @TypeConverter fun toLocalDateTime(value: Long): LocalDateTime =
        LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC)

    // ENUMS --------------
    @TypeConverter fun fromExerciseCategory(value: ExerciseCategory) = value.name
    @TypeConverter fun toExerciseCategory(value: String) = enumValueOf<ExerciseCategory>(value)

    @TypeConverter fun fromForceType(value: ForceType) = value.name
    @TypeConverter fun toForceType(value: String) = enumValueOf<ForceType>(value)

    @TypeConverter fun fromLevelType(value: LevelType) = value.name
    @TypeConverter fun toLevelType(value: String) = enumValueOf<LevelType>(value)

    @TypeConverter fun fromMechanicType(value: MechanicType) = value.name
    @TypeConverter fun toMechanicType(value: String) = enumValueOf<MechanicType>(value)

    @TypeConverter fun fromEquipmentType(value: EquipmentType) = value.name
    @TypeConverter fun toEquipmentType(value: String) = enumValueOf<EquipmentType>(value)
}