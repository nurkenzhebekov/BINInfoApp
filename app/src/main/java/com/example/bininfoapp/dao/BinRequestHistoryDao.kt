package com.example.bininfoapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bininfoapp.model.BinRequestHistory

@Dao
interface BinRequestHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(binRequestHistory: BinRequestHistory)

    @Query("SELECT * FROM bin_request_history ORDER BY id DESC")
    suspend fun getAllHistory(): List<BinRequestHistory>

    @Delete
    suspend fun delete(binRequestHistory: BinRequestHistory)
}