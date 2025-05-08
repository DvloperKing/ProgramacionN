package com.example.calculate_volumenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolumeCalculatorApp()
        }
    }
}

@Composable
fun VolumeCalculatorApp() {
    var selectedShape by remember { mutableStateOf("Cubo") }
    var inputValue by remember { mutableStateOf(TextFieldValue()) }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Calculadora de Volumen", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        DropdownMenuShapeSelector(selectedShape) { selectedShape = it }
        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Surface(modifier = Modifier.fillMaxWidth(), tonalElevation = 4.dp) {
                    Box(modifier = Modifier.padding(12.dp)) { innerTextField() }
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val value = inputValue.text.toDoubleOrNull()
            result = if (value != null) calculateVolume(selectedShape, value) else "Entrada inválida"
        }) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Resultado: $result", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun DropdownMenuShapeSelector(selectedShape: String, onShapeSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { expanded = true }) {
            Text(selectedShape)
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listOf("Cubo", "Esfera", "Cilindro").forEach { shape -> // Aquí definimos `shape`
                DropdownMenuItem(
                    text = { Text(text = shape) },
                    onClick = {
                        onShapeSelected(shape)
                        expanded = false
                    }
                )
            }
        }
    }
}

fun calculateVolume(shape: String, value: Double): String {
    return when (shape) {
        "Cubo" -> "${value.pow(3)} cm³"
        "Esfera" -> "${(4 / 3.0 * PI * value.pow(3))} cm³"
        "Cilindro" -> "Ingrese altura además del radio"
        else -> "Forma no soportada"
    }
}
