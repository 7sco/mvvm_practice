package com.example.franciscoandrade.tipcalculator.model

import android.arch.lifecycle.ViewModel
import java.math.RoundingMode

class RestaurantCalculator : ViewModel() {
    fun calculateTip(checkAmount: Double, tipPct:Int):TipCalculation{
        val tipAmount= (checkAmount * (tipPct.toDouble()/100.0)).toBigDecimal().setScale(2, RoundingMode.HALF_DOWN).toDouble()
        val grandTotal= checkAmount+tipAmount
        return TipCalculation(
                checkAmount=checkAmount,
                tipPct = tipPct,
                tipAmount = tipAmount,
                grandTotal = grandTotal
        )
    }
}
