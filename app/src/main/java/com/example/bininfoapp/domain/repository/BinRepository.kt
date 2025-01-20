package com.example.bininfoapp.domain.repository

import com.example.bininfoapp.data.local.BinEntity
import com.example.bininfoapp.domain.model.BinInfo

interface BinRepository {
    suspend fun getBinInfo(bin: String): BinInfo
    suspend fun saveBinInfo(binEntity: BinEntity)
    suspend fun getBinHistory(): List<BinEntity>
}