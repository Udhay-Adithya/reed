package com.udhay.reed.ui.features.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthViewModel : ViewModel() {

    private val _state = MutableStateFlow<AuthUiState>(AuthUiState.Success())
    val state: StateFlow<AuthUiState> = _state

    private val _events = MutableSharedFlow<AuthUiEvent>()
    val events: SharedFlow<AuthUiEvent> = _events.asSharedFlow()
}
