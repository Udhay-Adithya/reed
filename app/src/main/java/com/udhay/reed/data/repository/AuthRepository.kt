package com.udhay.reed.data.repository

import com.udhay.reed.data.model.AuthResponse
import com.udhay.reed.data.model.LoginRequest
import com.udhay.reed.data.model.RegisterRequest
import com.udhay.reed.data.network.ApiService
import com.udhay.reed.data.network.Resource
import org.koin.core.annotation.Single

@Single
class AuthRepository(private val apiService: ApiService) {
    suspend fun loginUser(loginRequest: LoginRequest): Resource<AuthResponse> {
        return try {
            val res = apiService.login(loginRequest)
            if (res.isSuccessful) {
                Resource.Success(res.body()!!)
            } else {
                Resource.Error("Login failed")
            }
        } catch (e: Exception) {
            Resource.Error("Unexpected error: ${e.message}")
        }
    }


    suspend fun registerUser(registerRequest: RegisterRequest): Resource<AuthResponse> {
        return try {
            val res = apiService.register(registerRequest)
            if (res.isSuccessful) {
                Resource.Success(res.body()!!)
            } else {
                Resource.Error("Login failed")
            }
        } catch (e: Exception) {
            Resource.Error("Unexpected error: ${e.message}")
        }
    }

}