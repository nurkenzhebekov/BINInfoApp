package com.example.bininfoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_history")
data class BinEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bin: String,
    val country: String?,
    val bank: String?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val timestamp: Long = System.currentTimeMillis()
)
