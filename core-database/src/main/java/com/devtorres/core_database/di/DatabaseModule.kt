package com.devtorres.core_database.di

import android.content.Context
import androidx.room.Room
import com.devtorres.core_database.FitAppDatabase
import com.devtorres.core_database.converter.ListStringConverter
import com.devtorres.core_database.dao.ExerciseDao
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
        listStringConverter: ListStringConverter
    ) : FitAppDatabase {
        return Room
            .databaseBuilder(context, FitAppDatabase::class.java, "fit_app_database")
            .fallbackToDestructiveMigration(true)
            .addTypeConverter(listStringConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(fitAppDatabase: FitAppDatabase) : ExerciseDao {
        return fitAppDatabase.exerciseDao()
    }

    @Provides
    @Singleton
    fun provideListStringConverter(moshi: Moshi) : ListStringConverter {
        return ListStringConverter(moshi)
    }
}