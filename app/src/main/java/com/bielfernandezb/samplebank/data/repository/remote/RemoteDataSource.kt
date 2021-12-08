package com.bielfernandezb.samplebank.data.repository.remote

import com.bielfernandezb.samplebank.data.repository.remote.api.TransactionsService
import com.bielfernandezb.samplebank.data.repository.remote.mapper.TransactionModelDataMapper
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val transactionsService: TransactionsService
) : BaseDataSource() {

    suspend fun getTransactions() =
        TransactionModelDataMapper().transform(getResult { transactionsService.getAllTransactions() })
}