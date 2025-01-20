package com.example.bininfoapp.app

import com.example.bininfoapp.dao.BinRequestHistoryDao
import com.example.bininfoapp.database.AppDatabase
import com.example.bininfoapp.repository.BinRequestHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBinRequestHistoryDao(appDatabase: AppDatabase): BinRequestHistoryDao {
        return appDatabase.binRequestHistoryDao()
    }

    @Provides
    fun provideBinRequestHistoryRepository(dao: BinRequestHistoryDao): BinRequestHistoryRepository {
        return BinRequestHistoryRepository(dao)
    }
}