package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _userResponse = MutableLiveData<ApiResponse<User>>()
    val userResponse: LiveData<ApiResponse<User>> = _userResponse

    fun getUser() {
        viewModelScope.launch {
            _userResponse.value = ApiResponse.Loading
            _userResponse.value = repository.getUser()
        }
    }
}