package com.devtorres.core_data.di

import com.devtorres.core_data.BreadcrumbsManagerImp
import com.devtorres.core_domain.repository.ExerciseRepository
import com.devtorres.core_data.ExerciseRepositoryImp
import com.devtorres.core_data.ProgressRepositoryImp
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_domain.repository.ProgressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsExerciseRepositoryImp(exerciseRepositoryImp: ExerciseRepositoryImp): ExerciseRepository

    @Binds
    fun bindsBreadcrumbsManagerImp(breadcrumbsManagerImp: BreadcrumbsManagerImp): BreadcrumbsManager

    @Binds
    fun bindsProgressRepositoryImp(progressRepositoryImp: ProgressRepositoryImp): ProgressRepository
}