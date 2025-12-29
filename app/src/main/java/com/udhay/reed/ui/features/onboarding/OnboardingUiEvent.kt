package com.udhay.reed.ui.features.onboarding

sealed interface OnboardingUiEvent {
    data class ShowErrorMessage(val message: String) : OnboardingUiEvent
}
