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

// Paquete que agrupa los temas visuales del proyecto Unscramble
package com.example.unscramble.ui.theme

// Importación de la clase Color que permite definir colores personalizados
import androidx.compose.ui.graphics.Color

// === TEMA CLARO (Light Theme) ===

// Color principal (primario) para componentes importantes
val md_theme_light_primary = Color(0xFF4355B9)
// Color sobre el color primario (texto o íconos)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
// Color del contenedor de elementos primarios (más suave)
val md_theme_light_primaryContainer = Color(0xFFDEE0FF)
// Color sobre el contenedor primario
val md_theme_light_onPrimaryContainer = Color(0xFF00105C)

// Color secundario para elementos menos relevantes
val md_theme_light_secondary = Color(0xFF5B5D72)
// Color sobre el secundario
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
// Contenedor del color secundario
val md_theme_light_secondaryContainer = Color(0xFFE0E1F9)
// Color sobre el contenedor secundario
val md_theme_light_onSecondaryContainer = Color(0xFF181A2C)

// Color terciario para elementos complementarios (menos frecuentes)
val md_theme_light_tertiary = Color(0xFF77536D)
// Color sobre el terciario
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
// Contenedor del color terciario
val md_theme_light_tertiaryContainer = Color(0xFFFFD7F1)
// Color sobre el contenedor terciario
val md_theme_light_onTertiaryContainer = Color(0xFF2D1228)

// Colores para mensajes de error
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)

// Fondo de pantalla o contenedor principal
val md_theme_light_background = Color(0xFFFEFBFF)
// Color sobre el fondo
val md_theme_light_onBackground = Color(0xFF1B1B1F)

// Color de la superficie (tarjetas, diálogos, etc.)
val md_theme_light_surface = Color(0xFFFEFBFF)
// Color sobre la superficie
val md_theme_light_onSurface = Color(0xFF1B1B1F)

// Variante de superficie, más neutra o secundaria
val md_theme_light_surfaceVariant = Color(0xFFE3E1EC)
val md_theme_light_onSurfaceVariant = Color(0xFF46464F)

// Bordes, divisores, etc.
val md_theme_light_outline = Color(0xFF767680)

// Colores inversos (para elementos oscuros sobre fondos claros)
val md_theme_light_inverseOnSurface = Color(0xFFF3F0F4)
val md_theme_light_inverseSurface = Color(0xFF303034)
val md_theme_light_inversePrimary = Color(0xFFBAC3FF)

// Tono para aplicar sobre elementos (barra de progreso, switches, etc.)
val md_theme_light_surfaceTint = Color(0xFF4355B9)

// Variante del contorno, usada para layouts complejos
val md_theme_light_outlineVariant = Color(0xFFC7C5D0)

// Capa semitransparente usada en modal, diálogos, overlays
val md_theme_light_scrim = Color(0xFF000000)


// === TEMA OSCURO (Dark Theme) ===

val md_theme_dark_primary = Color(0xFFBAC3FF)
val md_theme_dark_onPrimary = Color(0xFF08218A)
val md_theme_dark_primaryContainer = Color(0xFF293CA0)
val md_theme_dark_onPrimaryContainer = Color(0xFFDEE0FF)

val md_theme_dark_secondary = Color(0xFFC3C5DD)
val md_theme_dark_onSecondary = Color(0xFF2D2F42)
val md_theme_dark_secondaryContainer = Color(0xFF434659)
val md_theme_dark_onSecondaryContainer = Color(0xFFE0E1F9)

val md_theme_dark_tertiary = Color(0xFFE6BAD7)
val md_theme_dark_onTertiary = Color(0xFF44263D)
val md_theme_dark_tertiaryContainer = Color(0xFF5D3C55)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD7F1)

val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)

val md_theme_dark_background = Color(0xFF1B1B1F)
val md_theme_dark_onBackground = Color(0xFFE4E1E6)

val md_theme_dark_surface = Color(0xFF1B1B1F)
val md_theme_dark_onSurface = Color(0xFFE4E1E6)

val md_theme_dark_surfaceVariant = Color(0xFF46464F)
val md_theme_dark_onSurfaceVariant = Color(0xFFC7C5D0)

val md_theme_dark_outline = Color(0xFF90909A)

val md_theme_dark_inverseOnSurface = Color(0xFF1B1B1F)
val md_theme_dark_inverseSurface = Color(0xFFE4E1E6)
val md_theme_dark_inversePrimary = Color(0xFF4355B9)

val md_theme_dark_surfaceTint = Color(0xFFBAC3FF)
val md_theme_dark_outlineVariant = Color(0xFF46464F)
val md_theme_dark_scrim = Color(0xFF000000)
