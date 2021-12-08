package com.bielfernandezb.samplebank.data.repository.remote.api

import com.bielfernandezb.samplebank.data.repository.remote.dto.FinancialTransactionDTO
import retrofit2.Response
import retrofit2.http.GET

interface TransactionsService {
    @GET("6e6478e64dba16a39237")
    suspend fun getAllTransactions(): Response<List<FinancialTransactionDTO>>
}