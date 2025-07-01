package com.example.testapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users/1")
    suspend fun getUser(): Response<User>
}