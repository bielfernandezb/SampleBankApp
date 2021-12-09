package com.bielfernandezb.samplebank.model.repository

import com.bielfernandezb.samplebank.model.repository.local.LocalDataSource
import com.bielfernandezb.samplebank.model.repository.remote.RemoteDataSource
import com.bielfernandezb.samplebank.model.repository.utils.performGetOperation
import com.bielfernandezb.samplebank.model.repository.utils.performSingleDatabaseGetOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    fun getTransactions() = performGetOperation(
        databaseQuery = { localDataSource.getAllTransactions() },
        networkCall = { remoteDataSource.getTransactions() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    fun getTransaction(id: Int) = performSingleDatabaseGetOperation(
        databaseQuery = { localDataSource.getTransaction(id) }
    )

}