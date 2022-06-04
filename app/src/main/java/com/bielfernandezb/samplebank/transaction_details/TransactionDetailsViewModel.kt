package com.bielfernandezb.samplebank.transaction_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import com.bielfernandezb.samplebank.model.repository.Repository
import com.bielfernandezb.samplebank.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _transaction = _id.switchMap { id ->
        repository.getTransaction(id)
    }

    val financialTransaction: LiveData<Resource<FinancialTransaction>> = _transaction

    fun start(id: Int) {
        _id.value = id
    }

}