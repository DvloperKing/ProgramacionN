/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * ...
 */

// Paquete donde se definen los temas visuales de la aplicación
package com.example.dessertclicker.ui.theme

// Importaciones necesarias para detectar el tema del sistema y aplicar colores
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

// Paleta de colores personalizada para el tema oscuro
private val DarkColorPalette = darkColors(
    primary = Purple200,         // Color principal en modo oscuro
    primaryVariant = Purple700,  // Variante del color primario
    secondary = Pink600          // Color secundario/acento
)

// Paleta de colores personalizada para el tema claro
private val LightColorPalette = lightColors(
    primary = Green600,          // Color principal en modo claro
    primaryVariant = Purple700,  // Variante del color primario
    secondary = Pink600          // Color secundario/acento
)

/**
 * Función composable que aplica el tema global de la app.
 *
 * @param darkTheme Si `true`, aplica el tema oscuro. Por defecto, se detecta automáticamente según el sistema.
 * @param content Contenido composable que será envuelto por el tema.
 */
@Composable
fun DessertClickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Detecta automáticamente si el sistema usa modo oscuro
    content: @Composable () -> Unit             // Slot para el contenido de UI
) {
    // Selecciona la paleta de colores según el modo actual
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // Aplica el tema visual a toda la interfaz
    MaterialTheme(
        colors = colors,         // Colores definidos arriba
        typography = Typography, // Tipografía definida en Type.kt
        shapes = Shapes,         // Formas (esquinas redondeadas) definidas en Shape.kt
        content = content        // Contenido de la UI que usará este tema
    )
}
