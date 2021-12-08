package com.bielfernandezb.samplebank.data.repository.remote.mapper

import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.data.repository.remote.dto.FinancialTransactionDTO
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction

class TransactionModelDataMapper {

    fun transform(transactionResource: Resource<List<FinancialTransactionDTO>>?): Resource<List<FinancialTransaction>> {
        val transactions = mutableListOf<FinancialTransaction>()
        transactionResource?.data?.forEach { it ->
            val transaction = FinancialTransaction(
                it.id,
                it.date,
                it.amount,
                it.fee,
                it.description
            )
            transactions.add(transaction)
        }

        return Resource(transactionResource!!.status, transactions, transactionResource.message)
    }
}