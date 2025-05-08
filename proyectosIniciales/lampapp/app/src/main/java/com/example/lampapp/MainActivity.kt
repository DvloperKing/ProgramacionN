package com.example.lampapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLightOn by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isLightOn) Color.Yellow else Color.DarkGray)
                    .clickable { isLightOn = !isLightOn },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isLightOn) "Luz Encendida" else "Luz Apagada",
                    fontSize = 24.sp,
                    color = if (isLightOn) Color.Black else Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}