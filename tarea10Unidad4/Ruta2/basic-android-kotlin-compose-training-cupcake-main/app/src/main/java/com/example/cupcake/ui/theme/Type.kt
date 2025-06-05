/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito, el software
 * distribuido bajo esta Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulta la Licencia para conocer el lenguaje específico que rige los permisos y limitaciones.
 */

package com.example.cupcake.ui.theme // Paquete que agrupa recursos de estilo como colores, formas y tipografía

// Importaciones necesarias para definir estilos de texto en Jetpack Compose
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Conjunto básico de estilos tipográficos usando Material Design 3.
 * Esta configuración se puede extender con más variantes como: headline, label, title, etc.
 */
val Typography = Typography(
    /**
     * Estilo para textos grandes del cuerpo (bodyLarge).
     * Este es el estilo por defecto para texto principal legible en párrafos o bloques.
     */
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,         // Usa la fuente predeterminada del sistema
        fontWeight = FontWeight.Normal,          // Peso normal (regular)
        fontSize = 16.sp,                        // Tamaño de fuente: 16sp
        lineHeight = 24.sp,                      // Altura de línea: 24sp (espaciado entre líneas)
        letterSpacing = 0.5.sp                   // Espaciado entre letras: 0.5sp
    )
)
