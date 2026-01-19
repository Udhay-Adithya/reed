package com.udhay.reed.data.repository

import com.google.gson.Gson
import com.udhay.reed.data.model.AuthResponse
import com.udhay.reed.data.model.LoginRequest
import com.udhay.reed.data.model.RegisterRequest
import com.udhay.reed.data.network.ApiService
import com.udhay.reed.data.network.Resource
import org.koin.core.annotation.Single

@Single
class AuthRepository(
    private val apiService: ApiService,
    gson: Gson
) : BaseRepository(gson) {

    suspend fun loginUser(
        loginRequest: LoginRequest
    ): Resource<AuthResponse> =
        safeApiCall {
            apiService.login(loginRequest)
        }
    suspend fun registerUser(
        registerRequest: RegisterRequest
    ): Resource<AuthResponse> =
        safeApiCall {
            apiService.register(registerRequest)
        }
}
