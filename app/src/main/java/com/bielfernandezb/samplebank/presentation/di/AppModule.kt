package com.bielfernandezb.samplebank.presentation.di

import com.bielfernandezb.samplebank.data.repository.TransactionsRepositoryImpl
import com.bielfernandezb.samplebank.domain.use_case.GetRemoteTransactionListUseCase
import com.bielfernandezb.samplebank.domain.use_case.GetTransactionUseCase
import com.bielfernandezb.samplebank.presentation.transaction.viewmodel.MainViewModel
import com.bielfernandezb.samplebank.presentation.transaction_details.viewmodel.TransactionDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGetRemoteTransactionListUseCase(repository: TransactionsRepositoryImpl): GetRemoteTransactionListUseCase =
        GetRemoteTransactionListUseCase(repository)

    @Singleton
    @Provides
    fun provideGetTransactionUseCase(repository: TransactionsRepositoryImpl): GetTransactionUseCase =
        GetTransactionUseCase(repository)

    @Singleton
    @Provides
    fun provideUseCaseMainViewModel(
        getRemoteTransactionListUseCase: GetRemoteTransactionListUseCase
    ) = MainViewModel(
        getRemoteTransactionListUseCase
    )

    @Singleton
    @Provides
    fun provideUseCaseTransactionDetailsViewModel(
        getTransactionUseCase: GetTransactionUseCase
    ) = TransactionDetailsViewModel(
        getTransactionUseCase
    )
}