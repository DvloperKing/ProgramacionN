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

// Declaración del paquete que contiene los temas visuales de la app Unscramble
package com.example.unscramble.ui.theme

// Importación de formas redondeadas para los componentes de UI
import androidx.compose.foundation.shape.RoundedCornerShape
// Importación del contenedor Shapes de Material3 que define las formas del tema
import androidx.compose.material3.Shapes
// Importación de la unidad de medida dp (density-independent pixels)
import androidx.compose.ui.unit.dp

// Definición del objeto Shapes que contiene las formas redondeadas del tema actual
val Shapes = Shapes(
    // Forma redondeada pequeña (por ejemplo: botones o chips)
    small = RoundedCornerShape(4.dp),
    // Forma redondeada mediana (por ejemplo: tarjetas o cuadros de texto)
    medium = RoundedCornerShape(10.dp),
    // Forma redondeada grande (por ejemplo: diálogos o tarjetas destacadas)
    large = RoundedCornerShape(16.dp)
)
