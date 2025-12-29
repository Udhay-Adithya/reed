package com.udhay.reed.ui.features.auth
sealed interface AuthUiEvent {
    data class ShowErrorMessage(val message: String) : AuthUiEvent
}
