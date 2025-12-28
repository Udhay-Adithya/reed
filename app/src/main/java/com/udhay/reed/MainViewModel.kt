package com.udhay.reed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import com.udhay.reed.data.repository.StatusRepository

@KoinViewModel
class MainViewModel(private val statusRepository: StatusRepository) : ViewModel() {
    private val state = MutableStateFlow(mapOf<String, String>())
    val status = state.asStateFlow()

    init {
        getStatus()
    }

    private fun getStatus() {
        viewModelScope.launch {
            state.value = statusRepository.getStatus()
        }
    }
}