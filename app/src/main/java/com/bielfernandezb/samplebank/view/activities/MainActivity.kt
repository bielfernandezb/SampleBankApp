package com.bielfernandezb.samplebank.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bielfernandezb.samplebank.databinding.ActivityMainBinding
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import com.bielfernandezb.samplebank.utils.Resource
import com.bielfernandezb.samplebank.utils.Utils
import com.bielfernandezb.samplebank.view.MainViewModel
import com.bielfernandezb.samplebank.view.adapters.TransactionAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TransactionAdapter.TransactionItemListener {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = TransactionAdapter(this)
        binding.recyclerList.layoutManager = LinearLayoutManager(this)
        binding.recyclerList.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerList.getContext(),
            (binding.recyclerList.layoutManager as LinearLayoutManager).getOrientation()
        )
        binding.recyclerList.addItemDecoration(dividerItemDecoration)
    }

    private fun setupObservers() {
        viewModel.transactions.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        adapter.setItems(ArrayList(it.data))
                        binding.accountBalance.text =
                            Utils.calcTotalAmount(it.data.toList() as ArrayList<FinancialTransaction>)
                                .plus("€")
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        })
        binding.swipe.setOnRefreshListener {
            viewModel.refreshTransactions()
            binding.swipe.isRefreshing = false
        }
    }


    override fun onClickedFinancialTransaction(FinancialTransactionId: Int?) {
        val intent = Intent(this, TransactionDetailsActivity::class.java)
        val bundle = Bundle()
        if (FinancialTransactionId != null) {
            bundle.putInt("transactionId", FinancialTransactionId)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}