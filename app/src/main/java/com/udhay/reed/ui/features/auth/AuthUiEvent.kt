package com.udhay.reed.ui.features.auth
sealed interface AuthUiEvent {
    data class Login(val email: String, val password: String) : AuthUiEvent
    data class Signup(val name : String, val email: String, val password: String) : AuthUiEvent

}
