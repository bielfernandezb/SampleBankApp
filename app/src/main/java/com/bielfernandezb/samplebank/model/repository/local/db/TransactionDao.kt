package com.bielfernandezb.samplebank.model.repository.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAllTransactions(): LiveData<List<FinancialTransaction>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getTransaction(id: Int): LiveData<FinancialTransaction>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(financialTransactions: List<FinancialTransaction>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(financialTransaction: FinancialTransaction)
}