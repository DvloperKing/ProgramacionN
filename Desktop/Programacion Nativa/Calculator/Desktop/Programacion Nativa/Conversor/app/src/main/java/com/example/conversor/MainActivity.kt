package com.example.conversor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conversor.ui.theme.ConversorTheme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversorTheme {
                UnitConverterScreen()
            }
        }
    }
}

@Composable
fun UnitConverterScreen() {
    var amount by remember { mutableStateOf("") }
    var convertedAmount by remember { mutableStateOf("") }
    var selectedConversion by remember { mutableStateOf("km a mi") }

    val conversionRates = mapOf(
        "km a mi" to 0.621371,
        "mi a km" to 1.60934,
        "kg a lb" to 2.20462,
        "lb a kg" to 0.453592,
        "L a gal" to 0.264172,
        "gal a L" to 3.78541
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0x000071CB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Conversor de Unidades", fontSize = 26.sp, color = Color(0x000071CB))

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Cantidad") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        DropdownMenuSelection(selectedOption = selectedConversion, onOptionSelected = { selectedConversion = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val rate = conversionRates[selectedConversion] ?: 1.0
                val inputAmount = amount.toDoubleOrNull() ?: 0.0
                convertedAmount = "%.2f".format(inputAmount * rate)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF000000)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Convertir", color = Color.White, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Text(
                text = "Resultado: $convertedAmount",
                fontSize = 20.sp,
                color = Color(0xFF000000),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun DropdownMenuSelection(selectedOption: String, onOptionSelected: (String) -> Unit) {
    val options = listOf(
        "km a mi", "mi a km", "kg a lb",
        "lb a kg", "L a gal", "gal a L"
    )

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF000000)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = selectedOption, color = Color.White)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    ConversorTheme {
        UnitConverterScreen()
    }
}
