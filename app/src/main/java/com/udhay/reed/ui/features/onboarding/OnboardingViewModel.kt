package com.udhay.reed.ui.features.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class OnboardingViewModel : ViewModel() {

    private val _state = MutableStateFlow<OnboardingUiState>(OnboardingUiState.Success())
    val state: StateFlow<OnboardingUiState> = _state

    private val _events = MutableSharedFlow<OnboardingUiEvent>()
    val events: SharedFlow<OnboardingUiEvent> = _events.asSharedFlow()
}
