package com.example.bininfoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfoapp.model.BinRequestHistory
import com.example.bininfoapp.repository.BinRequestHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinRequestHistoryViewModel @Inject constructor(
    private val repository: BinRequestHistoryRepository
) : ViewModel(){

    private val _history = MutableLiveData<List<BinRequestHistory>>()
    val history: LiveData<List<BinRequestHistory>> get() = _history

    fun fetchHistory() {
        viewModelScope.launch {
            _history.postValue(repository.getHistory())
        }
    }

    fun addHistory(binRequestHistory: BinRequestHistory) {
        viewModelScope.launch {
            repository.insertHistory(binRequestHistory)
        }
    }
}