package com.example.bininfoapp.domain.usecase

import com.example.bininfoapp.data.local.BinHistoryEntity
import com.example.bininfoapp.data.repository.BinHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveBinHistoryUseCase @Inject constructor(
    private val repository: BinHistoryRepository
) {
    suspend operator fun invoke(binHistory: BinHistoryEntity) {
        repository.saveBinHistory(binHistory)
    }
}

class GetBinHistoryUseCase @Inject constructor(
    private val repository: BinHistoryRepository
) {
    operator fun invoke(): Flow<List<BinHistoryEntity>> {
        return repository.getBinHistory()
    }
}