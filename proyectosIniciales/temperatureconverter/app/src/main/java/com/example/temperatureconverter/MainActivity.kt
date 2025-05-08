/* 3. Convertidor de Temperatura (Celsius/Fahrenheit) */
package com.example.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverterApp()
        }
    }
}

@Composable
fun TemperatureConverterApp() {
    var inputText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    if (inputText.isEmpty()) {
                        Text("Temperatura en °C:", fontSize = 16.sp, color = androidx.compose.ui.graphics.Color.Gray)
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val celsius = inputText.toFloatOrNull()
            if (celsius != null) {
                val fahrenheit = (celsius * 9 / 5) + 32
                result = "$celsius°C = ${"%.2f".format(fahrenheit)}°F"
            } else {
                result = "Entrada inválida"
            }
        }) {
            Text("Convertir a °F")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = result, fontSize = 20.sp)
    }
}
