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

package com.example.cupcake.ui.theme // Paquete que contiene los recursos temáticos (colores, tipografía, formas, etc.)

import androidx.compose.ui.graphics.Color // Importa la clase Color para definir colores personalizados en Compose

// -------------------------------
// 🎨 Paleta de colores para modo claro
// -------------------------------

val md_theme_light_primary = Color(0xFF984062)                 // Color principal (rosa intenso)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)               // Texto sobre el color principal
val md_theme_light_primaryContainer = Color(0xFFFFD9E2)        // Contenedor del color principal (más claro)
val md_theme_light_onPrimaryContainer = Color(0xFF3E001E)      // Texto sobre el contenedor primario

val md_theme_light_secondary = Color(0xFF74565F)               // Color secundario (vino suave)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)             // Texto sobre el color secundario
val md_theme_light_secondaryContainer = Color(0xFFFFD9E2)      // Contenedor del secundario
val md_theme_light_onSecondaryContainer = Color(0xFF2B151C)    // Texto sobre el contenedor secundario

val md_theme_light_tertiary = Color(0xFF7C5635)                // Color terciario (marrón claro)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDCC2)
val md_theme_light_onTertiaryContainer = Color(0xFF2E1500)

val md_theme_light_error = Color(0xFFBA1A1A)                   // Color para errores
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)

val md_theme_light_background = Color(0xFFFFFBFF)             // Color de fondo general
val md_theme_light_onBackground = Color(0xFF201A1B)           // Texto sobre fondo
val md_theme_light_surface = Color(0xFFFFFBFF)                // Color de superficies (como tarjetas)
val md_theme_light_onSurface = Color(0xFF201A1B)              // Texto sobre superficies

val md_theme_light_surfaceVariant = Color(0xFFF2DDE2)         // Variante de superficie
val md_theme_light_onSurfaceVariant = Color(0xFF514347)

val md_theme_light_outline = Color(0xFF837377)                // Líneas o bordes
val md_theme_light_inverseOnSurface = Color(0xFFFAEEEF)       // Texto invertido sobre superficie
val md_theme_light_inverseSurface = Color(0xFF352F30)         // Superficie inversa (para dark mode en modo claro)
val md_theme_light_inversePrimary = Color(0xFFFFB0C9)         // Versión invertida del primario
val md_theme_light_surfaceTint = Color(0xFF984062)            // Color que se aplica como tinte de superficie
val md_theme_light_outlineVariant = Color(0xFFD5C2C6)
val md_theme_light_scrim = Color(0xFF000000)                  // Color de superposición (sombras, diálogos)


// -------------------------------
// 🌙 Paleta de colores para modo oscuro
// -------------------------------

val md_theme_dark_primary = Color(0xFFFFB0C9)
val md_theme_dark_onPrimary = Color(0xFF5E1133)
val md_theme_dark_primaryContainer = Color(0xFF7B294A)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFD9E2)

val md_theme_dark_secondary = Color(0xFFE2BDC7)
val md_theme_dark_onSecondary = Color(0xFF422931)
val md_theme_dark_secondaryContainer = Color(0xFF5A3F47)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFD9E2)

val md_theme_dark_tertiary = Color(0xFFEFBD94)
val md_theme_dark_onTertiary = Color(0xFF48290C)
val md_theme_dark_tertiaryContainer = Color(0xFF623F20)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDCC2)

val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)

val md_theme_dark_background = Color(0xFF201A1B)
val md_theme_dark_onBackground = Color(0xFFEBE0E1)
val md_theme_dark_surface = Color(0xFF201A1B)
val md_theme_dark_onSurface = Color(0xFFEBE0E1)

val md_theme_dark_surfaceVariant = Color(0xFF514347)
val md_theme_dark_onSurfaceVariant = Color(0xFFD5C2C6)

val md_theme_dark_outline = Color(0xFF9E8C90)
val md_theme_dark_inverseOnSurface = Color(0xFF201A1B)
val md_theme_dark_inverseSurface = Color(0xFFEBE0E1)
val md_theme_dark_inversePrimary = Color(0xFF984062)
val md_theme_dark_surfaceTint = Color(0xFFFFB0C9)
val md_theme_dark_outlineVariant = Color(0xFF514347)
val md_theme_dark_scrim = Color(0xFF000000)
