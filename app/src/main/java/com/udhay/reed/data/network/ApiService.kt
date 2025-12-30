package com.udhay.reed.data.network

import com.udhay.reed.data.model.AuthResponse
import com.udhay.reed.data.model.LoginRequest
import com.udhay.reed.data.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/status")
    suspend fun getStatus(): Response<Map<String, String>>

    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>
}
