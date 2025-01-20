package com.example.bininfoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BinEntity::class], version = 1, exportSchema = false)
abstract class BinDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}