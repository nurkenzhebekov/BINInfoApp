package com.example.bininfoapp.domain.usecase

import com.example.bininfoapp.data.model.BinResponse
import com.example.bininfoapp.data.repository.BinRepository

import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(
    private val repository: BinRepository
) {
    suspend operator fun invoke(bin: String): BinResponse = repository.getBinInfo(bin)
}