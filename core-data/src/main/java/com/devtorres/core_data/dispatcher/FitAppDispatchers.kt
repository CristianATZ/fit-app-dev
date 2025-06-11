package com.devtorres.core_data.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val type: FitAppDispatchers)

enum class FitAppDispatchers {
    IO,
}