package com.example.calculadoraapp

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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraApp()
        }
    }
}

@Composable
fun CalculadoraApp() {
    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var resultado by remember { mutableStateOf("Resultado:") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora", fontSize = 24.sp, color = Color.Blue)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de entrada para el primer número
        BasicTextField(
            value = num1,
            onValueChange = { num1 = it },
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de entrada para el segundo número
        BasicTextField(
            value = num2,
            onValueChange = { num2 = it },
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botones de operaciones
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { resultado = calcular(num1.text, num2.text, "+") }) {
                Text("+")
            }
            Button(onClick = { resultado = calcular(num1.text, num2.text, "-") }) {
                Text("-")
            }
            Button(onClick = { resultado = calcular(num1.text, num2.text, "*") }) {
                Text("×")
            }
            Button(onClick = { resultado = calcular(num1.text, num2.text, "/") }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el resultado
        Text(text = resultado, fontSize = 18.sp, color = Color.Black)
    }
}

fun calcular(n1: String, n2: String, operador: String): String {
    val num1 = n1.toDoubleOrNull()
    val num2 = n2.toDoubleOrNull()

    if (num1 == null || num2 == null) return "Ingrese números válidos"

    val resultado = when (operador) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if (num2 != 0.0) num1 / num2 else return "Error: División por 0"
        else -> return "Operación inválida"
    }

    return "Resultado: $resultado"
}