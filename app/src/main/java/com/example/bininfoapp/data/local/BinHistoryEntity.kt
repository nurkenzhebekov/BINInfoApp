package com.example.bininfoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_history")
data class BinHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bin: String,
    val scheme: String?,
    val type: String?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val countryName: String?,
    val latitude: Double?,
    val longitude: Double?
)
