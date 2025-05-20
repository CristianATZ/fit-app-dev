package com.devtorres.core_data.di

import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_data.ExerciseRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsExerciseRepositoryImp(exerciseRepositoryImp: ExerciseRepositoryImp): ExerciseRepository
}