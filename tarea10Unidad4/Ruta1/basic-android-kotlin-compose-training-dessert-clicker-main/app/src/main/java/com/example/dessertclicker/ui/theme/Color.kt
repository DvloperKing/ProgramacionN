/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Paquete correspondiente al tema visual de la app
package com.example.dessertclicker.ui.theme

// Importación necesaria para definir colores personalizados en Compose
import androidx.compose.ui.graphics.Color

// ----------- 🎨 Tema claro (Light Theme) -----------

// Color primario para el tema claro
val md_theme_light_primary = Color(0xFF006781)
// Color que se usa sobre el primario (ej. texto blanco sobre fondo azul)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)

// Color del contenedor secundario (suele usarse en tarjetas o botones)
val md_theme_light_secondaryContainer = Color(0xFFCFE6F1)
// Color del contenido dentro del contenedor secundario
val md_theme_light_onSecondaryContainer = Color(0xFF071E26)

// Color de fondo general de la app (pantallas, superficies)
val md_theme_light_background = Color(0xFFFBFCFE)


// ----------- 🌙 Tema oscuro (Dark Theme) -----------

// Color primario para el tema oscuro
val md_theme_dark_primary = Color(0xFF5FD4FD)
// Color que se usa sobre el primario en modo oscuro
val md_theme_dark_onPrimary = Color(0xFF003544)

// Color del contenedor secundario en modo oscuro
val md_theme_dark_secondaryContainer = Color(0xFF354A53)
// Color del contenido dentro del contenedor secundario en modo oscuro
val md_theme_dark_onSecondaryContainer = Color(0xFFCFE6F1)

// Color de fondo general en modo oscuro
val md_theme_dark_background = Color(0xFF191C1D)
