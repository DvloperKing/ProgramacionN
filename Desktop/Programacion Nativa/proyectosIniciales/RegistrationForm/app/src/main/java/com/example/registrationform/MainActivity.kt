package com.example.registrationform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationFormApp()
        }
    }
}

@Composable
fun RegistrationFormApp() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var registered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (registered) {
            Text(text = "Registro Exitoso!", fontSize = 24.sp)
        } else {
            BasicTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField -> Text("Nombre: ") ; innerTextField() }
            )
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField -> Text("Correo: ") ; innerTextField() }
            )
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                decorationBox = { innerTextField -> Text("Contraseña: ") ; innerTextField() }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { registered = true }) {
                Text("Registrar")
            }
        }
    }
}