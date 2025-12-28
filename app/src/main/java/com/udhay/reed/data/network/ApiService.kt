package com.udhay.reed.data.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/status")
    suspend fun getStatus(): Response<Map<String, String>>
}
