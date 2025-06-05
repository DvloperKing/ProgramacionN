/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * ...
 */

// Paquete donde se agrupan las configuraciones del tema visual (colores, formas, tipografías, etc.)
package com.example.dessertclicker.ui.theme

// Importaciones necesarias para definir estilos de texto en Jetpack Compose
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Definición de la tipografía general utilizada por la aplicación.
// Basado en el sistema de diseño Material Design 2 (MaterialTheme.typography).
val Typography = Typography(

    // Estilo predeterminado para textos del cuerpo (parrafos, etiquetas, etc.)
    body1 = TextStyle(
        fontFamily = FontFamily.Default,     // Fuente por defecto del sistema
        fontWeight = FontWeight.Normal,      // Peso normal (no negrita)
        fontSize = 16.sp                     // Tamaño de fuente de 16sp
    ),

    // Estilo para títulos grandes (puede usarse en encabezados principales)
    h4 = TextStyle(
        color = Color(0xFF008577),           // Verde azulado personalizado
        fontSize = 33.sp                     // Tamaño grande
    ),

    // Estilo para subtítulos o encabezados pequeños
    h6 = TextStyle(
        color = Color(0x99000000),           // Negro translúcido (60% opacidad)
        fontSize = 20.sp                     // Tamaño medio
    )
)
