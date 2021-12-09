package com.bielfernandezb.samplebank.model.repository.remote.api

import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import retrofit2.Response
import retrofit2.http.GET

interface TransactionsService {
    @GET("/transactions.json")
    suspend fun getAllTransactions(): Response<List<FinancialTransaction>>
}