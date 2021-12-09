package com.bielfernandezb.samplebank.view.adapters

import android.annotation.SuppressLint
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bielfernandezb.samplebank.databinding.TransactionListItemBinding
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import com.bielfernandezb.samplebank.utils.Utils

class TransactionAdapter(private val listener: TransactionItemListener) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    private lateinit var binding: TransactionListItemBinding

    interface TransactionItemListener {
        fun onClickedFinancialTransaction(FinancialTransactionId: Int?)
    }

    private val items = ArrayList<FinancialTransaction>()

    fun setItems(items: ArrayList<FinancialTransaction>) {
        this.items.clear()
        checkItems(items)
    }

    private fun checkItems(items: ArrayList<FinancialTransaction>) {
        items.removeAll {
            it.date == null
        }
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        binding =
            TransactionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(items[position])
        if (Utils.calcAmount(items[position].amount, items[position].fee).toDouble() < 0) {
            binding.amount.setTextColor(RED)
        } else {
            binding.amount.setTextColor(GREEN)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

class TransactionViewHolder(
    private val itemBinding: TransactionListItemBinding,
    private val listener: TransactionAdapter.TransactionItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var financialTransaction: FinancialTransaction

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: FinancialTransaction) {
        this.financialTransaction = item
        itemBinding.amount.text =
            Utils.calcAmount(financialTransaction.amount, financialTransaction.fee)
        itemBinding.date.text = Utils.convertDate(financialTransaction.date.toString())
        itemBinding.details.text = financialTransaction.description.toString()
    }


    override fun onClick(v: View?) {
        listener.onClickedFinancialTransaction(financialTransaction.id)
    }
}