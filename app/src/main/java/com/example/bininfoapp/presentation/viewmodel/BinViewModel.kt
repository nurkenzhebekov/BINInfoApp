package com.example.bininfoapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.data.model.BinResponse
import com.example.bininfoapp.domain.usecase.GetBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinResponse?>(null)
    val binInfo: StateFlow<BinResponse?> get() = _binInfo

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            try {
                _binInfo.value = getBinInfoUseCase(bin)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Error fetching BIN info: ${e.message}"
            }
        }
    }
}