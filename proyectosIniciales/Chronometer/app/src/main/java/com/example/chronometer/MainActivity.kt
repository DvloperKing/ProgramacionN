package com.example.chronometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChronometerApp()
        }
    }
}

@Composable
fun ChronometerApp() {
    var time by remember { mutableStateOf(0L) }
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(isRunning) {
        while (isRunning) {
            delay(1000L)
            time++
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tiempo: $time s", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { isRunning = true }) {
                Text("Iniciar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { isRunning = false }) {
                Text("Pausar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                isRunning = false
                time = 0L
            }) {
                Text("Reiniciar")
            }
        }
    }
}
