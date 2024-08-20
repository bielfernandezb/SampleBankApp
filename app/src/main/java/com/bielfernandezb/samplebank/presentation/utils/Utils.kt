package com.bielfernandezb.samplebank.presentation.utils

import android.util.Log
import com.bielfernandezb.samplebank.domain.entity.FinancialTransaction
import java.math.RoundingMode
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class Utils {
    companion object {

        fun convertStringToInt(str: String): Int {
            return Integer.parseInt(str)
        }

        fun convertDate(dateStr: String): String {
            var result = ""
            try {
                val parser = SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.FRANCE)
                val date = parser.parse(dateStr)
                val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
                result = date?.let { formatter.format(it) } ?: ""
            } catch (e: ParseException) {
                Log.e("Date Parse Exception", e.toString())
            }
            return result
        }

        fun calcAmount(amount: Double?, fee: Double?): String {
            return if (amount != null && fee != null) {
                (amount - fee).toString()
            } else {
                amount.toString()
            }
        }

        fun calcTotalAmount(items: List<FinancialTransaction>): String {
            var total = 0.0
            var oper = 0.0
            for (item: FinancialTransaction in items.reversed()) {
                if (item.fee != null && item.amount != null) {
                    oper = item.amount - item.fee
                } else if (item.amount != null) {
                    oper = item.amount
                }
                total += oper
            }
            return total.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN).toDouble().toString()
        }

    }

}