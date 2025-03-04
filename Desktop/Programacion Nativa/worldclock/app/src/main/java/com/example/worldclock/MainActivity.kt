package com.example.worldclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorldClockApp()
        }
    }
}

@Composable
fun WorldClockApp() {
    var timeZones = listOf("GMT", "America/New_York", "Europe/London", "Asia/Tokyo", "Australia/Sydney", "America/Mexico_City")
    var currentTime by remember { mutableStateOf(getCurrentTimes(timeZones)) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        timeZones.forEach { zone ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(text = "${zone}: ${currentTime[zone]}", fontSize = 18.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { currentTime = getCurrentTimes(timeZones) }) {
            Text("Actualizar Horas")
        }
    }
}

fun getCurrentTimes(timeZones: List<String>): Map<String, String> {
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return timeZones.associateWith { zone ->
        dateFormat.timeZone = TimeZone.getTimeZone(zone)
        dateFormat.format(Date())
    }
}
