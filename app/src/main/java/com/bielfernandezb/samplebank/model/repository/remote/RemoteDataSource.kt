package com.bielfernandezb.samplebank.model.repository.remote

import com.bielfernandezb.samplebank.model.repository.remote.api.TransactionsService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val transactionsService: TransactionsService
) : BaseDataSource() {

    suspend fun getTransactions() = getResult { transactionsService.getAllTransactions() }
}