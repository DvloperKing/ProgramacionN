/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo exija o se acuerde por escrito, este archivo
 * se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.cupcake.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Definición de la tipografía base para el tema Material 3.
// Aquí se puede personalizar la familia tipográfica, el tamaño,
// el peso y otros atributos para diferentes estilos de texto.

/**
 * Estilo de texto para `bodyLarge`, usado frecuentemente para
 * cuerpos de texto en la UI (como párrafos, descripciones).
 *
 * Puedes agregar más estilos personalizados como `headlineLarge`,
 * `titleMedium`, `labelSmall`, etc. si se requiere.
 */
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,        // Familia tipográfica por defecto
        fontWeight = FontWeight.Normal,         // Peso normal (regular)
        fontSize = 16.sp,                       // Tamaño de fuente de 16sp (recomendado para lectura)
        lineHeight = 24.sp,                     // Altura de línea para mejorar legibilidad
        letterSpacing = 0.5.sp                  // Espaciado entre letras
    )
)
