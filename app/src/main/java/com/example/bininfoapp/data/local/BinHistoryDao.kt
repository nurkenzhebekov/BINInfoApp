package com.example.bininfoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinHistory(bin: BinHistoryEntity)

    @Query("SELECT * FROM bin_history ORDER BY id DESC")
    fun getAllHistory(): Flow<List<BinHistoryEntity>>
}