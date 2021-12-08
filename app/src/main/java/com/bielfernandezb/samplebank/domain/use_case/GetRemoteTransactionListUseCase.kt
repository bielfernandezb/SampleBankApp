package com.bielfernandezb.samplebank.domain.use_case

import androidx.lifecycle.LiveData
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import com.bielfernandezb.samplebank.domain.repository.TransactionsRepository
import javax.inject.Inject

class GetRemoteTransactionListUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) : BaseUseCase<Unit, LiveData<Resource<List<FinancialTransaction>>>> {

    override fun invoke(params: Unit): LiveData<Resource<List<FinancialTransaction>>> =
        transactionsRepository.getTransactions()

}