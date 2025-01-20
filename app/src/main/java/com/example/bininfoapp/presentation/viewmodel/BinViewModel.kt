package com.example.bininfoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.domain.model.BinInfo
import com.example.bininfoapp.domain.usecase.GetBinInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BinViewModel(
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo: StateFlow<BinInfo?> get() = _binInfo

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            _binInfo.value = getBinInfoUseCase(bin)
        }
    }
}