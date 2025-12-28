package com.udhay.reed.data.repository

import com.udhay.reed.data.network.ApiService
import org.koin.core.annotation.Single

@Single
class StatusRepository(private val apiService: ApiService) {
    suspend fun getStatus(): Map<String, String> {
        return apiService.getStatus().body() ?: mapOf("status" to "error")
    }
}