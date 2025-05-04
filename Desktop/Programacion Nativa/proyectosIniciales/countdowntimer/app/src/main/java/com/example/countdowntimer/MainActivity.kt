/* 1. Temporizador (Countdown Timer) */
package com.example.countdowntimer

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
            CountdownTimerApp()
        }
    }
}

@Composable
fun CountdownTimerApp() {
    var timeLeft by remember { mutableStateOf(10) }
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(isRunning) {
        while (isRunning && timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
        if (timeLeft == 0) {
            isRunning = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tiempo restante: $timeLeft s", fontSize = 24.sp)
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
                timeLeft = 10
            }) {
                Text("Reiniciar")
            }
        }
    }
}
