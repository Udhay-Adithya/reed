package com.udhay.reed.ui.features.onboarding

sealed interface OnboardingUiState {
    data object Loading : OnboardingUiState
    data class Success(val data: Any? = null) : OnboardingUiState
    data class Error(val message: String) : OnboardingUiState
}
