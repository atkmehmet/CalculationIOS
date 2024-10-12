package com.example.myapplication

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class CalculationView:ViewModel() {

    var calculationState by mutableStateOf(CalculationState())

    fun action(event:CalculationButtonAction){
        when(event){
            is  CalculationButtonAction.Calculate -> calculate()
            is  CalculationButtonAction.Clear -> clear()
            is CalculationButtonAction.Delete -> delete()
            is CalculationButtonAction.Number -> addNumber(event.number)
            is CalculationButtonAction.Operation -> operation(event.operation)
            is CalculationButtonAction.DivideHundred-> hundredDivide()
            is CalculationButtonAction.ChangeValue-> changeValue()
            is CalculationButtonAction.convertDouble-> ConvertDouble()
        }
    }
    fun ConvertDouble(){
        if (calculationState.numberOne ==""){
            calculationState = calculationState.copy(
                numberOne = "0."
            )
        } else if(calculationState.numberOne !="" && calculationState.operation?:""=="" &&  calculationState.numberTwo ==""){

            calculationState = calculationState.copy(
                numberOne =  calculationState.numberOne + "."
            )
        } else if (calculationState.numberOne != "" && calculationState.operation?:"" != "" && calculationState.numberTwo ==""){

            calculationState = calculationState.copy(
                numberTwo = "0."
            )
        } else if (calculationState.numberOne != "" && calculationState.operation?:"" != "" && calculationState.numberTwo != ""){
            calculationState = calculationState.copy(
                numberTwo = calculationState.numberTwo + "."
            )
        }
    }

    fun changeValue(){

        if ((calculationState.numberOne !="" )&&(calculationState.numberTwo =="") &&(calculationState.operation?:"" == "")){

            if (calculationState.numberOne.toInt()>0){
                calculationState = calculationState.copy(
                    numberOne = (calculationState.numberOne.toInt() *-1).toString()
                )
            }
            else
            {
                calculationState = calculationState.copy(
                    numberOne = (calculationState.numberOne.toInt() *-1).toString()
                )
            }
        }

    }

    fun hundredDivide(){

        if ((calculationState.numberOne !="" )&&(calculationState.numberTwo =="") &&(calculationState.operation?:"" == "")){

            calculationState = calculationState.copy(
                numberOne = ((calculationState.numberOne.toInt())*0.01).toString()
            )
        }


    }

    fun calculate(){

        if((calculationState.numberOne.isNotEmpty()) && (calculationState.numberTwo.isNotEmpty()) &&(calculationState.operation?.symbol?.isNotEmpty() == true) )
        {
            val valueOne = calculationState.numberOne.toDoubleOrNull()
            val valueTwo = calculationState.numberTwo.toDoubleOrNull()

           if (valueOne != null && valueTwo != null) {
               val result = when (calculationState.operation!!.symbol) {
                   "+" -> (valueOne +valueTwo)
                   "-" -> (valueOne - valueTwo)
                   "/" -> (valueOne / valueTwo)
                   "*" -> (valueOne * valueTwo)
                   else -> 0
               }


               calculationState = calculationState.copy(

                   numberOne = result.toString(),
                   numberTwo = "",
                   operation = null
               )
           }

        }
    }
    fun clear(){

    }
    fun delete (){

        calculationState = calculationState.copy(
            numberOne = "0",
            numberTwo = "",
            operation = null
        )
    }
    fun addNumber(number: Int){

        if (calculationState.numberOne.isNotEmpty() && (calculationState.operation?.symbol?.isNotEmpty() == true)){

            calculationState = calculationState.copy(
                numberTwo = calculationState.numberTwo + number.toString()
            )
        }
        else
        {
            if(calculationState.numberOne == "0"){

                calculationState = calculationState.copy(
                    numberOne =  number.toString()
                )
            }else {

                calculationState = calculationState.copy(
                    numberOne = calculationState.numberOne + number.toString()
                )
            }

        }

    }
    fun operation(operation: CalculationOperation){
        calculationState = calculationState.copy(
            operation = operation
        )
    }

}