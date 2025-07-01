package com.example.testapp

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val throws: String) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}