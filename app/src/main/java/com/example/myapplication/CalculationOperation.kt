package com.example.myapplication

sealed class CalculationOperation(val symbol:String) {

    object  Add:       CalculationOperation("+")
    object  Substract: CalculationOperation("-")
    object  Multible:  CalculationOperation("*")
    object  Divide:     CalculationOperation("/")

}