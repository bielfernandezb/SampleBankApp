package com.bielfernandezb.samplebank.domain.repository

import androidx.lifecycle.LiveData
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction

interface TransactionsRepository {
    fun getTransactions(): LiveData<Resource<List<FinancialTransaction>>>

    fun getTransaction(id: Int): LiveData<Resource<FinancialTransaction>>
}