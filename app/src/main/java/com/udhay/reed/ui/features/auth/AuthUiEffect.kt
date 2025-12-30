package com.udhay.reed.ui.features.auth

sealed interface AuthUiEffect {
    data class ShowErrorMessage(val message: String) : AuthUiEffect
    data object NavigateToHome : AuthUiEffect
}
