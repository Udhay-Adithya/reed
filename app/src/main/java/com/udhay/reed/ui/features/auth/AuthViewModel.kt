package com.udhay.reed.ui.features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhay.reed.data.model.LoginRequest
import com.udhay.reed.data.model.RegisterRequest
import com.udhay.reed.data.network.Resource
import com.udhay.reed.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel(val repository: AuthRepository) : ViewModel() {

    private val _state = MutableStateFlow<AuthUiState>(AuthUiState.Initial)
    val state: StateFlow<AuthUiState> = _state

    private val _effect = MutableSharedFlow<AuthUiEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: AuthUiEvent){
        when(event){
            is AuthUiEvent.Login -> login(event.email, event.password)
            is AuthUiEvent.Signup -> signup(event.name, event.email, event.password)
        }
    }

    private fun login(email: String, password: String){
        viewModelScope.launch {
            _state.value = AuthUiState.Loading

            if (email.isBlank() || password.isBlank()) {
                _state.value = AuthUiState.Error("Invalid credentials")
                _effect.emit(
                    AuthUiEffect.ShowErrorMessage("Email or password cannot be empty")
                )
                return@launch
            }

            val res = repository.loginUser(LoginRequest(email, password))

            when(res){
                is Resource.Error -> {
                    _state.value = AuthUiState.Error(res.message)
                    _effect.emit(
                        AuthUiEffect.ShowErrorMessage(res.message))
                }
                is Resource.Success -> {
                    _state.value = AuthUiState.Success
                    _effect.emit(AuthUiEffect.NavigateToHome)

                }
            }

        }
    }

    private fun signup(name: String, email: String, password: String){
        viewModelScope.launch {
            _state.value = AuthUiState.Loading

            if (email.isBlank() || password.isBlank() || name.isBlank()) {
                _state.value = AuthUiState.Error("Invalid credentials")
                _effect.emit(
                    AuthUiEffect.ShowErrorMessage("Email or password cannot be empty")
                )
                return@launch
            }

            val res = repository.registerUser(RegisterRequest(name, email, password))

            when(res){
                is Resource.Error -> {
                    _state.value = AuthUiState.Error(res.message)
                    _effect.emit(
                        AuthUiEffect.ShowErrorMessage(res.message))
                }
                is Resource.Success -> {
                    _state.value = AuthUiState.Success
                    _effect.emit(AuthUiEffect.NavigateToHome)

                }
            }

        }
    }
}
