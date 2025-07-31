package com.devtorres.fit_app

import android.app.Application
import android.os.StrictMode
import com.jaikeerthick.composable_graphs.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FitApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }
    }

    private fun enableStrictMode() {
        // Detecta operaciones en el hilo principal
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll() // detecta: disk reads, disk writes, network, slow calls
                .penaltyLog() // imprime en Logcat
                .penaltyDialog() // muestra un diálogo (solo para pruebas)
                //.penaltyDeath() // opcional, mata la app al detectar
                .build()
        )

        // Detecta errores a nivel de objetos (leaks de recursos, etc)
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                //.penaltyDeath() // opcional
                .build()
        )
    }
}