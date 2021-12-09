package com.bielfernandezb.samplebank

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleBankApplication : Application() {
    private var mInstance: SampleBankApplication? = null

    @Synchronized
    fun getInstance(): SampleBankApplication? {
        return mInstance
    }

    override fun onCreate() {
        mInstance = this
        super.onCreate()
    }
}