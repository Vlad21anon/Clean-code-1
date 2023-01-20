package com.ukadovlad21.cleanarch.di

import com.ukadovlad21.cleanarch.presentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}