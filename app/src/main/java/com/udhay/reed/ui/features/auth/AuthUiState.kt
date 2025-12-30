package com.udhay.reed.ui.features.auth

sealed interface AuthUiState {
    data object Initial : AuthUiState
    data object Loading : AuthUiState
    data object Success : AuthUiState
    data class Error(val message: String) : AuthUiState
}
