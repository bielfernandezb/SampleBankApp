package com.bielfernandezb.samplebank.presentation.transaction_details.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bielfernandezb.samplebank.core.Resource
import com.bielfernandezb.samplebank.databinding.FragmentTransactionDetailsBinding
import com.bielfernandezb.samplebank.presentation.BaseFragment
import com.bielfernandezb.samplebank.presentation.navigation.Navigator.Companion.TRANSACTION_ID
import com.bielfernandezb.samplebank.presentation.transaction_details.viewmodel.TransactionDetailsViewModel
import com.bielfernandezb.samplebank.presentation.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentTransactionDetailsBinding
    private val viewModel: TransactionDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(TRANSACTION_ID)?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.financialTransaction.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { transaction ->
                        binding.textTotal.text =
                            Utils.calcAmount(transaction.amount, transaction.fee)
                        binding.textDateHolder.text = Utils.convertDate(transaction.date.toString())
                        binding.textDetails.text = transaction.description
                    }
                }

                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                else -> {}
            }
        }
    }
}