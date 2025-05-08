package com.example.quicknotes

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
            QuickNotesApp()
        }
    }
}

@Composable
fun QuickNotesApp() {
    var noteText by remember { mutableStateOf("") }
    var savedNote by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = noteText,
            onValueChange = { noteText = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { savedNote = noteText }) {
            Text("Guardar Nota")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nota Guardada:", fontSize = 18.sp)
        Text(text = savedNote, fontSize = 22.sp)
    }
}
