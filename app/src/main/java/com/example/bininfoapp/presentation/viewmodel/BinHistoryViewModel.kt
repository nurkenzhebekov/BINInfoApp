package com.example.bininfoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.data.local.BinHistoryEntity
import com.example.bininfoapp.domain.usecase.GetBinHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BinHistoryViewModel @Inject constructor(
    private val getBinHistoryUseCase: GetBinHistoryUseCase
) : ViewModel() {

    val history: StateFlow<List<BinHistoryEntity>> =
        getBinHistoryUseCase().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}