package com.bielfernandezb.samplebank.data.repository.local

import com.bielfernandezb.samplebank.data.repository.local.db.TransactionDao
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val transactionDao: TransactionDao
) {

    fun getAllTransactions() = transactionDao.getAllTransactions()

    fun getTransaction(id: Int) = transactionDao.getTransaction(id)

    suspend fun insertAll(financialTransactions: List<FinancialTransaction>) =
        transactionDao.insertAll(financialTransactions)
}