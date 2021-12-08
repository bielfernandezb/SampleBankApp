package com.bielfernandezb.samplebank.data.repository

import com.bielfernandezb.samplebank.data.repository.local.LocalDataSource
import com.bielfernandezb.samplebank.data.repository.remote.RemoteDataSource
import com.bielfernandezb.samplebank.data.repository.utils.performGetOperation
import com.bielfernandezb.samplebank.data.repository.utils.performSingleDatabaseGetOperation
import com.bielfernandezb.samplebank.domain.repository.TransactionsRepository
import javax.inject.Inject

class TransactionsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : TransactionsRepository {

    override fun getTransactions() = performGetOperation(
        databaseQuery = { localDataSource.getAllTransactions() },
        networkCall = { remoteDataSource.getTransactions() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    override fun getTransaction(id: Int) = performSingleDatabaseGetOperation(
        databaseQuery = { localDataSource.getTransaction(id) }
    )

}