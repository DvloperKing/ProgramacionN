package com.example.generatepass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.generatepass.ui.theme.GeneratePassTheme
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeneratePassTheme {
                PasswordGeneratorScreen()
            }
        }
    }
}

@Composable
fun PasswordGeneratorScreen() {
    var password by remember { mutableStateOf("") }
    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Generador de Contraseñas", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {},
            readOnly = true,
            label = { Text("Contraseña Generada") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { password = generatePassword(12) }) {
            Text(text = "Generar Contraseña")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { clipboardManager.setText(AnnotatedString(password)) }) {
            Text(text = "Copiar")
        }
    }
}

fun generatePassword(length: Int): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()"
    return (1..length)
        .map { charset[Random.nextInt(charset.length)] }
        .joinToString("")
}

@Preview(showBackground = true)
@Composable
fun PasswordGeneratorPreview() {
    GeneratePassTheme {
        PasswordGeneratorScreen()
    }
}
