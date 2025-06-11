package com.devtorres.core_data.di

import com.devtorres.core_data.dispatcher.Dispatcher
import com.devtorres.core_data.dispatcher.FitAppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {

    @Provides
    @Dispatcher(FitAppDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}