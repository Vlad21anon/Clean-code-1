package com.ukadovlad21.cleanarch.app

import android.app.Application
import com.ukadovlad21.cleanarch.di.appModule
import com.ukadovlad21.cleanarch.di.dataModule
import com.ukadovlad21.cleanarch.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }
}
