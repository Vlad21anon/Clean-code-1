package com.ukadovlad21.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ukadovlad21.cleanarch.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

//        val vm = ViewModelProvider(this,MainViewModelFactory(applicationContext))[MainViewModel::class.java]

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

//class MainViewModelFactory(applicationContext: Context) : ViewModelProvider.Factory {
//
//
//    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//        UserRepositoryImpl(SharedPrefUserStorage(applicationContext))
//    }
//    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        GetUserNameUseCase(userRepository)
//    }
//    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        SaveUserNameUseCase(userRepository)
//    }
//
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return MainViewModel(
//            getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase) as T
//    }
//}