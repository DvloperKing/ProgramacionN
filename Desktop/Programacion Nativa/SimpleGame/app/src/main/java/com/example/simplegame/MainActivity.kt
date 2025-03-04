package com.example.simplegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplegame.ui.theme.SimpleGameTheme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleGameTheme {
                CurrencyConverterScreen()
            }
        }
    }
}

@Composable
fun CurrencyConverterScreen() {
    var amount by remember { mutableStateOf("") }
    var convertedAmount by remember { mutableStateOf("") }
    var selectedConversion by remember { mutableStateOf("Pesos a Dólares") }

    val conversionRates = mapOf(
        "Pesos a Dólares" to 0.058,
        "Pesos a Euros" to 0.054,
        "Pesos a Bolívares" to 24.5,
        "Dólares a Pesos" to 17.2,
        "Euros a Pesos" to 18.5,
        "Bolívares a Pesos" to 0.041
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Conversor de Moneda", fontSize = 24.sp)

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

        Button(onClick = {
            val rate = conversionRates[selectedConversion] ?: 1.0
            val inputAmount = amount.toDoubleOrNull() ?: 0.0
            convertedAmount = "%.2f".format(inputAmount * rate)
        }) {
            Text(text = "Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Resultado: $convertedAmount", fontSize = 18.sp)
    }
}

@Composable
fun DropdownMenuSelection(selectedOption: String, onOptionSelected: (String) -> Unit) {
    val options = listOf(
        "Pesos a Dólares", "Pesos a Euros", "Pesos a Bolívares",
        "Dólares a Pesos", "Euros a Pesos", "Bolívares a Pesos"
    )

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { expanded = true }) {
            Text(text = selectedOption)
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
fun CurrencyConverterPreview() {
    SimpleGameTheme {
        CurrencyConverterScreen()
    }
}
