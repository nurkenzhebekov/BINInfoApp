package com.example.bininfoapp

import com.example.bininfoapp.data.model.BinResponse
import com.example.bininfoapp.data.repository.BinRepository
import com.example.bininfoapp.domain.usecase.GetBinInfoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

/*
class UnitTest {
    @Test
    fun `getBinInfo returns data`() = runBlocking {
        val mockRepository = mock(BinRepository::class.java)
        val useCase = GetBinInfoUseCase(mockRepository)

        val mockResponse = BinResponse(scheme = "visa", type = "debit", bank = null, country = null)
        `when`(mockRepository.getBinInfo("45717360")).thenReturn(mockResponse)

        val result = useCase("45717360")
        assertEquals("visa", result.scheme)
}*/
