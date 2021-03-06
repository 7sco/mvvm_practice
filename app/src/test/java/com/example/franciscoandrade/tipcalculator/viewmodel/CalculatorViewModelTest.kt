package com.example.franciscoandrade.tipcalculator.viewmodel

import com.example.franciscoandrade.tipcalculator.model.RestaurantCalculator
import com.example.franciscoandrade.tipcalculator.model.TipCalculation
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {

    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var  mockCalculator: RestaurantCalculator

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        calculatorViewModel= CalculatorViewModel(mockCalculator)
    }

    @Test
    fun TestCalculateTip(){
        calculatorViewModel.inputCheckAmount="10.00"
        calculatorViewModel.inputTipPercentage="15"

        val stub= TipCalculation(checkAmount = 10.00, tipAmount = 1.5, grandTotal = 11.5)
        `when`(mockCalculator.calculateTip(10.00, 15)).thenReturn(stub)
        calculatorViewModel.calculateTip()

//        assertEquals(10.00, calculatorViewModel.tipCalculation.checkAmount)
//        assertEquals(1.50, calculatorViewModel.tipCalculation.tipAmount)
//        assertEquals(11.50, calculatorViewModel.tipCalculation.grandTotal)

        assertEquals(stub, calculatorViewModel.tipCalculation)
    }

    @Test
    fun testCalculateTipBadTipPercent(){
        calculatorViewModel.inputCheckAmount="10.00"
        calculatorViewModel.inputTipPercentage=""

        calculatorViewModel.calculateTip()
        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

    @Test
    fun testCalculateTipBadCheckInputAmount(){
        calculatorViewModel.inputCheckAmount=""
        calculatorViewModel.inputTipPercentage="15"

        calculatorViewModel.calculateTip()
        verify(mockCalculator, never()).calculateTip(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt())
    }

}