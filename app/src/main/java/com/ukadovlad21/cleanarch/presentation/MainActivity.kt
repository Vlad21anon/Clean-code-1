package com.ukadovlad21.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ukadovlad21.cleanarch.R
import com.ukadovlad21.data.repository.UserRepositoryImpl
import com.ukadovlad21.data.storage.sharedprefs.SharedPrefUserStorage
import com.ukadovlad21.domain.usecase.GetUserNameUseCase
import com.ukadovlad21.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)


        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val params = com.ukadovlad21.domain.models.SaveUserNameParam(text)
            val result = saveUserNameUseCase.execute(params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName: com.ukadovlad21.domain.models.UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstname} ${userName.lastname}"
        }


    }
}