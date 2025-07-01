package com.example.testapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val repository = UserRepoImpl(apiService)
        val viewModelFactory = UserViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        viewModel.userResponse.observe(this) {
            when(it) {
                is ApiResponse.Loading -> ""
                is ApiResponse.Success -> ""
                is ApiResponse.Error -> ""
            }
        }

        findViewById<Button>(R.id.call_button).setOnClickListener {

        }
    }
}