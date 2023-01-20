package com.ukadovlad21.cleanarch.app

import android.app.Application
import com.ukadovlad21.cleanarch.di.AppComponent
import com.ukadovlad21.cleanarch.di.AppModule
import com.ukadovlad21.cleanarch.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}