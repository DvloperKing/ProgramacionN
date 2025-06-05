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

// Paquete de tema visual de la app
package com.example.dessertclicker.ui.theme

// Importaciones necesarias para configurar temas y manipular colores en Compose
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Definición del esquema de color oscuro usando colores personalizados (definidos en Color.kt)
private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    background = md_theme_dark_background,
)

// Definición del esquema de color claro usando colores personalizados
private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    background = md_theme_light_background,
)

/**
 * Función Composable que aplica el tema de la aplicación.
 *
 * @param darkTheme Determina si se aplica el tema oscuro. Por defecto, detecta el modo del sistema.
 * @param dynamicColor Si es `true`, usa esquemas de color dinámicos (Android 12+). En este caso está desactivado por fines educativos.
 * @param content Contenido composable que usará el tema.
 */
@Composable
fun DessertClickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),  // Usa el tema oscuro si el sistema lo está usando
    dynamicColor: Boolean = false,               // Colores dinámicos desactivados por fines educativos
    content: @Composable () -> Unit              // Slot para el contenido de la interfaz
) {
    // Determina qué esquema de color aplicar según los parámetros y versión de Android
    val colorScheme = when {
        // Usa colores dinámicos si están habilitados y el dispositivo tiene Android 12 o superior
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Si no, aplica el tema oscuro o claro estático
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Obtiene la vista actual para modificar la apariencia del sistema (barra de estado y navegación)
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Cambia el color de la barra de estado al color primario del esquema
            window.statusBarColor = colorScheme.primary.toArgb()
            // Cambia el color de la barra de navegación al color del contenedor secundario
            window.navigationBarColor = colorScheme.secondaryContainer.toArgb()
            // Define si los iconos de la barra de estado deben tener apariencia clara u oscura
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    // Aplica el esquema de colores al MaterialTheme para el resto de la app
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
