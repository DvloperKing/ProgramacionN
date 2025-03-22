/* 7. Generador de Código de Barras */
package com.example.barcodegenerator

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarcodeGeneratorApp()
        }
    }
}

@Composable
fun BarcodeGeneratorApp() {
    var inputText by remember { mutableStateOf("") }
    var barcodeBitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    if (inputText.isEmpty()) {
                        Text("Introduce texto para generar código de barras", fontSize = 16.sp)
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            barcodeBitmap = generateBarcode(inputText)
        }) {
            Text("Generar Código de Barras")
        }
        Spacer(modifier = Modifier.height(16.dp))
        barcodeBitmap?.let {
            Image(bitmap = it.asImageBitmap(), contentDescription = "Código de Barras", modifier = Modifier.size(300.dp, 100.dp))
        }
    }
}

fun generateBarcode(text: String): Bitmap {
    val width = 600
    val height = 200
    val bitMatrix: BitMatrix = MultiFormatWriter().encode(text, BarcodeFormat.CODE_128, width, height)
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
        }
    }
    return bitmap
}
