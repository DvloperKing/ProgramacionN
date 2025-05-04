package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.GrayCustom
import com.example.calculadora.ui.theme.OrangeCustom
import java.math.RoundingMode

@Composable
fun CalculatorUI() {
    // Variables
    var expression = remember { mutableStateOf("") }
    val buttonSpacing = 10.dp

    // Screen
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth(),
                reverseLayout = true
            ){
                item {
                    // Expression
                    Text(
                        text = expression.value,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp, horizontal = 8.dp),
                        fontWeight = FontWeight.Light,
                        fontSize = 80.sp,
                        color = Color.White,
                        maxLines = 1
                    )
                }
            }
            // Divide the expression between buttons
            Divider(
                color = Color.Black,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )
            // Buttons
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {

                NumberButton("C", expression)
                NumberButton("(", expression)
                NumberButton(")", expression)
                NumberButton("/", expression)
            }
            // Buttons
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumberButton("1", expression)
                NumberButton("2", expression)
                NumberButton("3", expression)
                NumberButton("X", expression)
            }
            // Buttons
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumberButton("4", expression)
                NumberButton("5", expression)
                NumberButton("6", expression)
                NumberButton("-", expression)
            }
            // Buttons
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumberButton("7", expression)
                NumberButton("8", expression)
                NumberButton("9", expression)
                NumberButton("+", expression)
            }
            // Buttons
            Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                NumberButton(",", expression)
                NumberButton("0", expression)
                NumberButton("AC", expression)
                NumberButton("=", expression)
            }
        }
    }
}

@Composable
fun NumberButton(number: String, expression: MutableState<String>) {
    val model = Calculations()

    // Button Colors
    val backgroundColor = when (number) {
        "C", "(", ")" -> GrayCustom
        "/", "+", "-", "X", "=" -> OrangeCustom
        else -> Color.DarkGray
    }

    // Button Text Colors
    val textColor = if (number == "C" || number == "(" || number == ")") {
        Color.Black
    } else {
        Color.White
    }

    // Button
    Button(
        onClick = {
            // Clear entire expression
            if (number == "AC") {
                expression.value = ""

                // Delete one character from expression
            } else if (number == "C") {
                expression.value = expression.value.dropLast(1)

                // Calculate the expression
            } else if (number == "=") {
                try{
                    // Result
                    val result = model.ValidateExpression(expression.value)
                    val rounded = result?.toBigDecimal()?.setScale(5, RoundingMode.DOWN)?.toDouble()
                    expression.value = rounded.toString()

                } catch (error: ArithmeticException){
                    expression.value = ""
                }
                // Check if only one token is in the expression
            } else {
                if (number in listOf("+", "-", "X", "/", ",", "(", ")")) {
                    if (!expression.value.contains(number)) {
                        expression.value += number
                    }
                } else {
                    expression.value += number
                }
            }
        },
        modifier = Modifier.size(80.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)

    ) {
        // Button Label Design
        Text(
            text = number,
            style = TextStyle.Default,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = textColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorUI()
}
