package com.example.bininfoapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.data.local.BinHistoryEntity
import com.example.bininfoapp.data.model.BinResponse
import com.example.bininfoapp.domain.usecase.GetBinInfoUseCase
import com.example.bininfoapp.domain.usecase.SaveBinHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val saveBinHistoryUseCase: SaveBinHistoryUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinResponse?>(null)
    val binInfo: StateFlow<BinResponse?> get() = _binInfo

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            try {
                val binResponse = getBinInfoUseCase(bin)
                Log.d("MyLog", "Fetched full BIN info: $binResponse")
                _binInfo.value = binResponse
                _error.value = null

                saveBinHistory(binResponse, bin)
            } catch (e: Exception) {
                _error.value = "Error fetching BIN info: ${e.message}"
            }
        }
    }

    private suspend fun saveBinHistory(binResponse: BinResponse, bin: String) {
        saveBinHistoryUseCase(
            BinHistoryEntity(
                bin = bin,
                scheme = binResponse.scheme,
                type = binResponse.type,
                bankName = binResponse.bank?.name,
                bankUrl = binResponse.bank?.url,
                bankPhone = binResponse.bank?.phone,
                countryName = binResponse.country?.name,
                latitude = binResponse.country?.latitude,
                longitude = binResponse.country?.longitude
            )
        )
    }
}