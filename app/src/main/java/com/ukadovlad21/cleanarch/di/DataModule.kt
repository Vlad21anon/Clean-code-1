package com.ukadovlad21.cleanarch.di

import com.ukadovlad21.data.repository.UserRepositoryImpl
import com.ukadovlad21.data.storage.sharedprefs.SharedPrefUserStorage
import com.ukadovlad21.data.storage.sharedprefs.UserStorage
import com.ukadovlad21.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {


    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}