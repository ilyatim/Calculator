package com.unfixedbo1t.calculator

import android.app.Application
import com.unfixedbo1t.calculator.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}