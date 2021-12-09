package com.bielfernandezb.samplebank.di

import android.content.Context
import com.bielfernandezb.samplebank.model.repository.Repository
import com.bielfernandezb.samplebank.model.repository.local.LocalDataSource
import com.bielfernandezb.samplebank.model.repository.local.db.AppDatabase
import com.bielfernandezb.samplebank.model.repository.remote.RemoteDataSource
import com.bielfernandezb.samplebank.model.repository.remote.api.APIClient
import com.bielfernandezb.samplebank.model.repository.remote.api.APIClient.okHttpClient
import com.bielfernandezb.samplebank.model.repository.remote.api.TransactionsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(APIClient.BASE_URL)
        .addConverterFactory(APIClient.gSONConverter)
        .client(okHttpClient)
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideBeerService(retrofit: Retrofit): TransactionsService =
        retrofit.create(TransactionsService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideBeerDao(db: AppDatabase) = db.transactionDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ) = Repository(remoteDataSource, localDataSource)
}