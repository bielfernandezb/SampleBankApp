package com.bielfernandezb.samplebank.domain.use_case

import androidx.lifecycle.LiveData
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import com.bielfernandezb.samplebank.domain.repository.TransactionsRepository
import javax.inject.Inject

class GetTransactionUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) : BaseUseCase<Int, LiveData<Resource<FinancialTransaction>>> {

    override fun invoke(params: Int): LiveData<Resource<FinancialTransaction>> =
        transactionsRepository.getTransaction(params)

}