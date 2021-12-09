package com.bielfernandezb.samplebank.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import com.bielfernandezb.samplebank.model.repository.Repository
import com.bielfernandezb.samplebank.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val reloadTrigger = MutableLiveData<Boolean>()

    val transactions: LiveData<Resource<List<FinancialTransaction>>> =
        Transformations.switchMap(reloadTrigger) {
            repository.getTransactions()
        }

    init {
        refreshTransactions()
    }

    fun refreshTransactions() {
        reloadTrigger.value = true
    }

}
