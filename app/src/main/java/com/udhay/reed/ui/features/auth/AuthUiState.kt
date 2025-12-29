package com.udhay.reed.ui.features.auth

sealed interface AuthUiState {
    data object Loading : AuthUiState
    data class Success(val data: Any? = null) : AuthUiState
    data class Error(val message: String) : AuthUiState
}
