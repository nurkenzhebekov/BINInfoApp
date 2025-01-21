package com.example.bininfoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.data.local.BinHistoryEntity
import com.example.bininfoapp.data.model.BinResponse
import com.example.bininfoapp.domain.usecase.GetBinHistoryUseCase
import com.example.bininfoapp.domain.usecase.SaveBinHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinHistoryViewModel @Inject constructor(
    private val saveBinHistoryUseCase: SaveBinHistoryUseCase,
    private val getBinHistoryUseCase: GetBinHistoryUseCase
) : ViewModel() {

    val history: StateFlow<List<BinHistoryEntity>> =
        getBinHistoryUseCase().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun saveBinHistory(binResponse: BinResponse, bin: String) {
        viewModelScope.launch {
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
}