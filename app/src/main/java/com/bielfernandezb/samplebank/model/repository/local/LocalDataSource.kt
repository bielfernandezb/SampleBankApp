package com.bielfernandezb.samplebank.model.repository.local

import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import com.bielfernandezb.samplebank.model.repository.local.db.TransactionDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val transactionDao: TransactionDao
) {

    fun getAllTransactions() = transactionDao.getAllTransactions()

    fun getTransaction(id: Int) = transactionDao.getTransaction(id)

    suspend fun insertAll(financialTransactions: List<FinancialTransaction>) =
        transactionDao.insertAll(financialTransactions)
}