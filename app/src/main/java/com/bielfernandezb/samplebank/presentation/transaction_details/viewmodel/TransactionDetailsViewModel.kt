package com.bielfernandezb.samplebank.presentation.transaction_details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import com.bielfernandezb.samplebank.domain.use_case.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor(
    private val getTransactionUseCase: GetTransactionUseCase
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _transaction = _id.switchMap { id ->
        getTransactionUseCase.invoke(id)
    }

    val financialTransaction: LiveData<Resource<FinancialTransaction>> = _transaction

    fun start(id: Int) {
        _id.value = id
    }

}