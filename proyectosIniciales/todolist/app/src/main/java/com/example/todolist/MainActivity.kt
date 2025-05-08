package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var taskText by remember { mutableStateOf(TextFieldValue()) }
            var tasks by remember { mutableStateOf(listOf<String>()) }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = taskText,
                    onValueChange = { taskText = it },
                    label = { Text("Nueva tarea") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    if (taskText.text.isNotBlank()) {
                        tasks = tasks + taskText.text
                        taskText = TextFieldValue()
                    }
                }) {
                    Text("Agregar tarea")
                }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn {
                    items(tasks) { task ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(8.dp),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(task, modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        }
    }
}
