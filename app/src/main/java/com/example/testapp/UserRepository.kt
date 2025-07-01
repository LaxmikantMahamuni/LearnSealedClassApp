package com.example.testapp

interface UserRepository {
    suspend fun getUser(): ApiResponse<User>
}

class UserRepoImpl(private val apiService: ApiService): UserRepository{
    override suspend fun getUser(): ApiResponse<User> {
        return try {
            val response = apiService.getUser()
            if (response.isSuccessful && response.body()!= null){
                return ApiResponse.Success(response.body()!!)
            } else {
                return ApiResponse.Error("${response.code()}")
            }
        } catch (e: Exception) {
            ApiResponse.Error(e.localizedMessage)
        }
    }
}