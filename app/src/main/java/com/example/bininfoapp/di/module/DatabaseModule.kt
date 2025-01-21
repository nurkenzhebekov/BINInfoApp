package com.example.bininfoapp.di.module

import android.content.Context
import androidx.room.Room
import com.example.bininfoapp.data.local.AppDatabase
import com.example.bininfoapp.data.local.BinHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "bin_history_db"
        ).build()
    }

    @Provides
    fun provideBinHistoryDao(database: AppDatabase): BinHistoryDao {
        return database.binHistoryDao()
    }
}