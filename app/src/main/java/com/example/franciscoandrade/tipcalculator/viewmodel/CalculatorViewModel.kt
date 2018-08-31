package com.example.franciscoandrade.tipcalculator.viewmodel

import android.util.Log
import com.example.franciscoandrade.tipcalculator.model.RestaurantCalculator
import com.example.franciscoandrade.tipcalculator.model.TipCalculation

class CalculatorViewModel (val calculator:RestaurantCalculator = RestaurantCalculator()){

    var inputCheckAmount=""

    var inputTipPercentage=""

    var tipCalculation= TipCalculation()

    fun calculateTip(){
        Log.d("MVVM", "CalculateTipInvoked ");
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()
        if (checkAmount!=null && tipPct!= null){
            tipCalculation = calculator.calculateTip(checkAmount, tipPct)
        }
    }
}