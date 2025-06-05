/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Archivo licenciado bajo la Licencia Apache 2.0. Consulta https://www.apache.org/licenses/LICENSE-2.0
 */

package com.example.sports // Paquete principal de la app Sports

// Importaciones necesarias para el ciclo de vida de la actividad, Compose y gestión de diseño responsivo
import android.os.Bundle
import androidx.activity.ComponentActivity // Clase base para actividades que usan Jetpack Compose
import androidx.activity.compose.setContent // Para establecer el contenido con Compose
import androidx.activity.enableEdgeToEdge // Para habilitar que el contenido ocupe toda la pantalla
import androidx.compose.foundation.layout.* // Importación de WindowInsets y layout
import androidx.compose.material3.Surface // Componente base para UI con fondo
import androidx.compose.material3.windowsizeclass.* // Utilidades para detectar tamaño de pantalla
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection // Dirección de diseño (LTR o RTL)
import com.example.sports.ui.SportsApp // Importa el Composable principal de la app
import com.example.sports.ui.theme.SportsTheme // Tema personalizado de la app

/**
 * Actividad principal de la app Sports.
 * Usa Jetpack Compose como motor de UI.
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class) // Se habilita el uso de API experimental
class MainActivity : ComponentActivity() {

    // Método llamado cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita que el contenido se dibuje hasta los bordes (sin barras de sistema)
        super.onCreate(savedInstanceState)

        // Establece la UI de la app usando Jetpack Compose
        setContent {
            SportsTheme { // Aplica el tema personalizado de la app
                val layoutDirection = LocalLayoutDirection.current // Obtiene la dirección de lectura del dispositivo (LTR o RTL)

                Surface( // Componente que actúa como fondo seguro para la UI
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection), // Asegura que haya padding en el inicio (según orientación)
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection) // Asegura que haya padding en el final (según orientación)
                        )
                ) {
                    // Detecta el tamaño de la pantalla (compacto, mediano, expandido)
                    val windowSize = calculateWindowSizeClass(this)

                    // Llama al Composable principal, pasando el tamaño de pantalla y acción de regreso
                    SportsApp(
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = { finish() } // Cierra la actividad cuando se pulsa atrás
                    )
                }
            }
        }
    }
}
