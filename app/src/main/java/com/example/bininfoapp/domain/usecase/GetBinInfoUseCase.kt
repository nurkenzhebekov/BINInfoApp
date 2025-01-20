package com.example.bininfoapp.domain.usecase

import com.example.bininfoapp.domain.model.BinInfo
import com.example.bininfoapp.domain.repository.BinRepository

class GetBinInfoUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(bin: String): BinInfo {
        return repository.getBinInfo(bin)
    }
}