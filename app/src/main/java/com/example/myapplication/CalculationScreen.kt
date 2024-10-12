package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculationScreen(view: CalculationView){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(bottom = CommonValues.space),
        verticalArrangement =Arrangement.Bottom
    ) {


        Text(
            text = view.calculationState.numberOne + (view.calculationState.operation?.symbol?:"") + view.calculationState.numberTwo ,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color = Color.White,
            maxLines = 2
        )


        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            calculationButton(
                color = Color.LightGray,
                symbol = "AC",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Delete)}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "+/-",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.ChangeValue)}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "%",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.DivideHundred)}


            )


            calculationButton(
                color = Color.Yellow,
                symbol = "/",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Operation(CalculationOperation.Divide))}


            )
        }
        Spacer(modifier = Modifier.height(CommonValues.space))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            calculationButton(
                color = Color.LightGray,
                symbol = "7",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(7))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "8",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(8))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "9",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(9))}


            )


            calculationButton(
                color = Color.Yellow,
                symbol = "X",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Operation(CalculationOperation.Multible))}


            )
        }
        Spacer(modifier = Modifier.height(CommonValues.space))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            calculationButton(
                color = Color.LightGray,
                symbol = "4",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(4))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "5",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(5))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "6",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(6))}


            )


            calculationButton(
                color = Color.Yellow,
                symbol = "-",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Operation(CalculationOperation.Substract))}


            )
        }
        Spacer(modifier = Modifier.height(CommonValues.space))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            calculationButton(
                color = Color.LightGray,
                symbol = "1",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(1))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "2",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(2))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = "3",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Number(3))}


            )


            calculationButton(
                color = Color.Yellow,
                symbol = "+",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Operation(CalculationOperation.Add))}


            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            calculationButton(
                color = Color.LightGray,
                symbol = "0",
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                onClick ={ view.action(CalculationButtonAction.Number(0))}


            )
            calculationButton(
                color = Color.LightGray,
                symbol = ",",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.convertDouble)}


            )
            calculationButton(
                color = Color.Yellow,
                symbol = "=",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick ={ view.action(CalculationButtonAction.Calculate)}


            )
        }
    }
}