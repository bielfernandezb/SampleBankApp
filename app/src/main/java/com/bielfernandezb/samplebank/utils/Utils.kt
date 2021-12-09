package com.bielfernandezb.samplebank.utils

import android.util.Log
import com.bielfernandezb.samplebank.model.entities.FinancialTransaction
import java.text.ParseException
import java.text.SimpleDateFormat
import kotlin.math.roundToLong

class Utils {
    companion object {
        fun convertStringToInt(str: String): Int {
            return Integer.parseInt(str)
        }

        fun convertDate(dateStr: String): String {

            var result: String = ""
            try {
                val parser = SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy")
                val date = parser.parse(dateStr)
                val formatter = SimpleDateFormat("yyyy-MM-dd")
                val formattedDate = formatter.format(date)
                result = formattedDate
            } catch (e: ParseException) {
                Log.e("Date Parse Exception", e.toString())
            }
            return result
        }

        fun calcAmount(amount: Double?, fee: Double?): String {
            if (amount != null && fee != null) {
                return (amount - fee).toString()
            } else {
                return amount.toString()
            }
        }

        fun calcTotalAmount(items: ArrayList<FinancialTransaction>): String {
            var total: Double = 0.0
            var oper: Double = 0.0
            for (item: FinancialTransaction in items.reversed()) {
                if (item.fee != null && item.amount != null) {
                    oper = item.amount - item.fee
                } else if (item.amount != null) {
                    oper = item.amount!!
                }
                total += oper
            }
            return total.roundToLong().toString()
        }
    }
}