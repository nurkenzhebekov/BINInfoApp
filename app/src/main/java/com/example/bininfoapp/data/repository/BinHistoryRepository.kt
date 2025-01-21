package com.example.bininfoapp.data.repository

import com.example.bininfoapp.data.local.BinHistoryDao
import com.example.bininfoapp.data.local.BinHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BinHistoryRepository @Inject constructor(
    private val binHistoryDao: BinHistoryDao
) {
    suspend fun saveBinHistory(binHistory: BinHistoryEntity) {
        binHistoryDao.insertBinHistory(binHistory)
    }

    fun getBinHistory(): Flow<List<BinHistoryEntity>> {
        return binHistoryDao.getAllHistory()
    }
}