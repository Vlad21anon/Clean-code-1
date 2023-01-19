package com.ukadovlad21.cleanarch.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ukadovlad21.data.repository.UserRepositoryImpl
import com.ukadovlad21.data.storage.sharedprefs.SharedPrefUserStorage
import com.ukadovlad21.domain.usecase.GetUserNameUseCase
import com.ukadovlad21.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(applicationContext: Context) : ViewModelProvider.Factory {


    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase) as T
    }
}