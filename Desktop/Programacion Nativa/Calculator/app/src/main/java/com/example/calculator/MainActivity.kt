package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                CalculatorApp()
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input Fields
        BasicTextField(
            value = num1,
            onValueChange = { num1 = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = num2,
            onValueChange = { num2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Operation Buttons
        Row {
            Button(onClick = {
                result = calculate(num1.text, num2.text, "+")
            }) {
                Text("+")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = calculate(num1.text, num2.text, "-")
            }) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = calculate(num1.text, num2.text, "*")
            }) {
                Text("×")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = calculate(num1.text, num2.text, "/")
            }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Result Display
        Text(
            text = "Result: $result",
            fontSize = 20.sp
        )
    }
}

// Function to perform calculations
fun calculate(num1: String, num2: String, operator: String): String {
    val n1 = num1.toDoubleOrNull()
    val n2 = num2.toDoubleOrNull()

    return if (n1 != null && n2 != null) {
        when (operator) {
            "+" -> (n1 + n2).toString()
            "-" -> (n1 - n2).toString()
            "*" -> (n1 * n2).toString()
            "/" -> if (n2 != 0.0) (n1 / n2).toString() else "Cannot divide by zero"
            else -> "Invalid Operation"
        }
    } else {
        "Enter valid numbers"
    }
}
