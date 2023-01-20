package com.ukadovlad21.cleanarch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ukadovlad21.data.repository.UserRepositoryImpl
import com.ukadovlad21.data.storage.sharedprefs.SharedPrefUserStorage
import com.ukadovlad21.domain.usecase.GetUserNameUseCase
import com.ukadovlad21.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {

    private var _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "VM cleared")
    }

//    fun getResultLive():LiveData<String> {
//        return resultLive
//    }

    fun save(text: String) {
        val params = com.ukadovlad21.domain.models.SaveUserNameParam(text)
        val resultData = saveUserNameUseCase.execute(params)
        _resultLive.value = "Save result = $resultData"
    }


    fun load() {
        val userName: com.ukadovlad21.domain.models.UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstname} ${userName.lastname}"
    }
}