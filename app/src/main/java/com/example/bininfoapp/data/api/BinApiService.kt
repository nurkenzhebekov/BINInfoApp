package com.example.bininfoapp.data.api

import com.example.bininfoapp.data.model.BinInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApiService {
    @GET("/{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoResponse
}