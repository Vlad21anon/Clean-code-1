package com.ukadovlad21.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ukadovlad21.cleanarch.R
import com.ukadovlad21.data.repository.UserRepositoryImpl
import com.ukadovlad21.data.storage.sharedprefs.SharedPrefUserStorage
import com.ukadovlad21.domain.usecase.GetUserNameUseCase
import com.ukadovlad21.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            vm.save(text)
        }
        receiveButton.setOnClickListener {
            vm.load()
        }


    }
}