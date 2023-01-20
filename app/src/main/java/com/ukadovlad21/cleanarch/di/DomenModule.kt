package com.ukadovlad21.cleanarch.di

import com.ukadovlad21.domain.usecase.GetUserNameUseCase
import com.ukadovlad21.domain.usecase.SaveUserNameUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module {


    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}