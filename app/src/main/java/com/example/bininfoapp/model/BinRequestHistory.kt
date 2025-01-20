package com.example.bininfoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_request_history")
data class BinRequestHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val bin: String,
    val country: String,
    val cardType: String,
    val bankName: String,
    val bankUrl: String
)
