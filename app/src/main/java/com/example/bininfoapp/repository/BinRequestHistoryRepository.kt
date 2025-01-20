package com.example.bininfoapp.repository

import com.example.bininfoapp.dao.BinRequestHistoryDao
import com.example.bininfoapp.model.BinRequestHistory

class BinRequestHistoryRepository(private val binRequestHistoryDao: BinRequestHistoryDao) {

    suspend fun insertHistory(binRequestHistory: BinRequestHistory) {
        binRequestHistoryDao.insert(binRequestHistory)
    }

    suspend fun getHistory(): List<BinRequestHistory> {
        return binRequestHistoryDao.getAllHistory()
    }
}