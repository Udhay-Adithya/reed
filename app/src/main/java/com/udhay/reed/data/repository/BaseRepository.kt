package com.udhay.reed.data.repository

import com.google.gson.Gson
import com.udhay.reed.data.model.ErrorResponse
import com.udhay.reed.data.network.Resource
import retrofit2.Response

abstract class BaseRepository(
    protected val gson: Gson
) {

    protected suspend fun <T> safeApiCall(
        apiCall: suspend () -> Response<T>
    ): Resource<T> {
        return try {
            val response = apiCall()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Resource.Success(body)
                } else {
                    Resource.Error("Empty response from server")
                }
            } else {
                Resource.Error(
                    message = parseError(response),
                )
            }
        } catch (e: Exception) {
            Resource.Error(
                message = "Network error",
                throwable = e
            )
        }
    }

    private fun <T> parseError(response: Response<T>): String {
        return try {
            val errorBody = response.errorBody()?.string()

            if (errorBody.isNullOrEmpty()) {
                "Unknown error"
            } else {
                val errorResponse =
                    gson.fromJson(errorBody, ErrorResponse::class.java)
                errorResponse.message ?: "Unknown error"
            }
        } catch (e: Exception) {
            "Something went wrong"
        }
    }
}
