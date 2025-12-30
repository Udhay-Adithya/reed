package com.udhay.reed.data.network

sealed class Resource<T>() {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(
        val message: String, val throwable: Throwable? = null, val data: T? = null
    ) : Resource<T>()
}