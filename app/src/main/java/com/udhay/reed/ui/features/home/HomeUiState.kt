package com.udhay.reed.ui.features.home

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val data: Any? = null) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
