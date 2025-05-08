package com.example.ahorcadogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ahorcadogame.ui.theme.AhorcadoGameTheme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AhorcadoGameTheme {
                HangmanGameScreen()
            }
        }
    }
}

@Composable
fun HangmanGameScreen() {
    val wordToGuess = "KOTLIN"
    var guessedWord by remember { mutableStateOf("_".repeat(wordToGuess.length)) }
    var remainingAttempts by remember { mutableStateOf(6) }
    var guessedLetters by remember { mutableStateOf(emptySet<Char>()) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Juego del Ahorcado", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Palabra: $guessedWord", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Intentos restantes: $remainingAttempts", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { input ->
                val letter = input.uppercase().firstOrNull()
                if (letter != null && letter in 'A'..'Z' && letter !in guessedLetters) {
                    guessedLetters = guessedLetters + letter
                    if (letter in wordToGuess) {
                        guessedWord = wordToGuess.map { if (it in guessedLetters) it else '_' }.joinToString("")
                    } else {
                        remainingAttempts--
                    }
                    if (guessedWord == wordToGuess) {
                        message = "¡Ganaste!"
                    } else if (remainingAttempts == 0) {
                        message = "Perdiste. La palabra era $wordToGuess"
                    }
                }
            },
            label = { Text("Ingresa una letra") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (message.isNotEmpty()) {
            Text(text = message, fontSize = 22.sp, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HangmanGamePreview() {
    AhorcadoGameTheme {
        HangmanGameScreen()
    }
}
