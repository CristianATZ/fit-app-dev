package com.devtorres.core_database.di

import android.content.Context
import androidx.room.Room
import com.devtorres.core_database.FitAppDatabase
import com.devtorres.core_database.callback.EquipmentPopulatorCallback
import com.devtorres.core_database.callback.ExercisesPopulatorCallback
import com.devtorres.core_database.callback.SupplementsPopulatorCallback
import com.devtorres.core_database.converter.MapConverter
import com.devtorres.core_database.converter.MoshiConverters
import com.devtorres.core_database.dao.EquipmentDao
import com.devtorres.core_database.dao.ExerciseDao
import com.devtorres.core_database.dao.ProgressDao
import com.devtorres.core_database.dao.SupplementDao
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMoshi() : Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        moshiConverters: MoshiConverters,
        mapConverter: MapConverter,
        exercisesPopulatorCallback: ExercisesPopulatorCallback,
        supplementsPopulatorCallback: SupplementsPopulatorCallback,
        equipmentPopulatorCallback: EquipmentPopulatorCallback
    ) : FitAppDatabase {
        return Room
            .databaseBuilder(context, FitAppDatabase::class.java, "fit_app_database")
            .fallbackToDestructiveMigration(true)
            .addTypeConverter(moshiConverters)
            .addTypeConverter(mapConverter)
            .addCallback(exercisesPopulatorCallback)
            .addCallback(supplementsPopulatorCallback)
            .addCallback(equipmentPopulatorCallback)
            .build()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(fitAppDatabase: FitAppDatabase) : ExerciseDao {
        return fitAppDatabase.exerciseDao()
    }

    @Provides
    @Singleton
    fun provideSupplementDao(fitAppDatabase: FitAppDatabase) : SupplementDao {
        return fitAppDatabase.supplementDao()
    }

    @Provides
    @Singleton
    fun provideEquipmentDao(fitAppDatabase: FitAppDatabase) : EquipmentDao {
        return fitAppDatabase.equipmentDao()
    }

    @Provides
    @Singleton
    fun provideProgressDao(fitAppDatabase: FitAppDatabase) : ProgressDao {
        return fitAppDatabase.progressDao()
    }

    @Provides
    @Singleton
    fun provideExercisesPopulatorCallback(
        @ApplicationContext context: Context,
        provider: Provider<ExerciseDao>,
        moshi: Moshi
    ) : ExercisesPopulatorCallback {
        return ExercisesPopulatorCallback(
            context = context,
            provider = provider,
            moshi = moshi
        )
    }

    @Provides
    @Singleton
    fun provideSupplementsPopulatorCallback(
        @ApplicationContext context: Context,
        provider: Provider<SupplementDao>,
        moshi: Moshi
    ) : SupplementsPopulatorCallback {
        return SupplementsPopulatorCallback(
            context = context,
            provider = provider,
            moshi = moshi
        )
    }

    @Provides
    @Singleton
    fun provideEquipmentsPopulatorCallback(
        @ApplicationContext context: Context,
        provider: Provider<EquipmentDao>,
        moshi: Moshi
    ) : EquipmentPopulatorCallback {
        return EquipmentPopulatorCallback(
            context = context,
            provider = provider,
            moshi = moshi
        )
    }

    @Provides
    @Singleton
    fun provideMoshiConverters(moshi: Moshi) : MoshiConverters {
        return MoshiConverters(moshi)
    }

    @Provides
    @Singleton
    fun provideMapConverter(moshi: Moshi) : MapConverter {
        return MapConverter(moshi)
    }
}