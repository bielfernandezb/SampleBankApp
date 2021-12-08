package com.bielfernandezb.samplebank.presentation.transaction.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import com.bielfernandezb.samplebank.domain.use_case.GetRemoteTransactionListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRemoteTransactionListUseCase: GetRemoteTransactionListUseCase
) : ViewModel() {

    private val reloadTrigger = MutableLiveData<Boolean>()

    val transactions: LiveData<Resource<List<FinancialTransaction>>> =
        Transformations.switchMap(reloadTrigger) {
            getRemoteTransactionListUseCase.invoke(Unit)
        }

    init {
        refreshTransactions()
    }

    fun refreshTransactions() {
        reloadTrigger.value = true
    }

}
