package com.example.myapplication

sealed class CalculationButtonAction {
    object Clear:CalculationButtonAction()
    object Delete:CalculationButtonAction()
    data class Operation(val operation: CalculationOperation):CalculationButtonAction()
    data class Number(val number:Int):CalculationButtonAction()
    object Calculate:CalculationButtonAction()
    object DivideHundred:CalculationButtonAction()
    object ChangeValue:CalculationButtonAction()
    object convertDouble:CalculationButtonAction()

}