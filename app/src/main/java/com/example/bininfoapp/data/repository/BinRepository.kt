package com.example.bininfoapp.data.repository

import com.example.bininfoapp.data.api.BinApiService
import com.example.bininfoapp.data.model.BinResponse
import javax.inject.Inject

class BinRepository @Inject constructor(
    private val apiService: BinApiService
) {
    suspend fun getBinInfo(bin: String): BinResponse = apiService.getBinInfo(bin)
}