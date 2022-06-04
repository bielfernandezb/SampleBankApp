package com.bielfernandezb.samplebank.transaction_details.views.activities

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bielfernandezb.samplebank.BaseActivity
import com.bielfernandezb.samplebank.R
import com.bielfernandezb.samplebank.transaction_details.views.fragments.TransactionDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_details)

        val b = intent.extras
        if (b != null) {
            val value = b.getInt("transactionId")
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val transactionDetailsFragment = TransactionDetailsFragment()
            val bundle = Bundle()
            bundle.putInt("transactionId", value)
            transactionDetailsFragment.arguments = bundle
            fragmentTransaction.add(R.id.main_content, transactionDetailsFragment).commit()
        }
    }
}