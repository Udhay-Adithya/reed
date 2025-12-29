package com.udhay.reed.ui.features.home

sealed interface HomeUiEvent {
    data class ShowErrorMessage(val message: String) : HomeUiEvent
}
