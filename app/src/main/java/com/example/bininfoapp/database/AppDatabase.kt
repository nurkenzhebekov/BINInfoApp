package com.example.bininfoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bininfoapp.dao.BinRequestHistoryDao
import com.example.bininfoapp.model.BinRequestHistory

@Database(entities = [BinRequestHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun binRequestHistoryDao(): BinRequestHistoryDao
}