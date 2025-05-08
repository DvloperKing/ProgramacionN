package com.example.gamedado

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
import com.example.gamedado.ui.theme.GameDadoTheme
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameDadoTheme {
                DiceGameScreen()
            }
        }
    }
}

@Composable
fun DiceGameScreen() {
    var diceValue by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Juego de Dado", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Dado: $diceValue", fontSize = 24.sp) // Reemplazo temporal de la imagen
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { diceValue = Random.nextInt(1, 7) }) {
            Text(text = "Girar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceGameScreenPreview() {
    GameDadoTheme {
        DiceGameScreen()
    }
}
