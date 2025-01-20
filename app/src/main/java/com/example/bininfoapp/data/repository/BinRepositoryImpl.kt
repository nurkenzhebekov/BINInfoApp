package com.example.bininfoapp.data.repository

import com.example.bininfoapp.data.api.BinApiService
import com.example.bininfoapp.data.local.BinDao
import com.example.bininfoapp.data.local.BinEntity
import com.example.bininfoapp.domain.model.BinInfo
import com.example.bininfoapp.domain.repository.BinRepository

class BinRepositoryImpl(
    private val apiService: BinApiService,
    private val binDao: BinDao
) : BinRepository {

    override suspend fun getBinInfo(bin: String): BinInfo {
        val response = apiService.getBinInfo(bin)
        return BinInfo(
            scheme = response.scheme,
            type = response.type,
            brand = response.brand,
            country = response.country?.name,
            bank = response.bank?.name
        )
    }

    override suspend fun saveBinInfo(binEntity: BinEntity) {
        binDao.insertBin(binEntity)
    }

    override suspend fun getBinHistory(): List<BinEntity> {
        return binDao.getBinHistory()
    }
}