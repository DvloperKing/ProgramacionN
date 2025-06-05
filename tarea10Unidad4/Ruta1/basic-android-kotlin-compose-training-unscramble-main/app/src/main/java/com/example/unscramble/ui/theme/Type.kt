/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unscramble.ui.theme // Paquete que define estilos visuales del tema de la app

// Importaciones necesarias para definir estilos de texto y fuentes en Compose
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Definición de un conjunto de estilos tipográficos personalizados para Material3
val Typography = Typography(
    headlineMedium = TextStyle( // Estilo para títulos medianos (headlineMedium)
        fontFamily = FontFamily.Default, // Usa la familia de fuentes por defecto del sistema
        fontWeight = FontWeight.Bold, // Aplica peso de fuente negrita
        fontSize = 28.sp, // Tamaño del texto en puntos escalables (sp)
        lineHeight = 36.sp, // Altura de línea recomendada para este tamaño
        letterSpacing = 0.5.sp // Espaciado adicional entre letras
    )
)
