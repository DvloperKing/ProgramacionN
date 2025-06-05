/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define la actividad principal de la app Reply.
 * Implementa un diseño adaptable según el tamaño de pantalla.
 */

package com.example.reply

// Importaciones necesarias para la actividad, diseño adaptable y tema visual
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.ui.ReplyApp
import com.example.reply.ui.theme.ReplyTheme

/**
 * MainActivity es la actividad principal de la aplicación.
 * Define el contenido de la pantalla usando Jetpack Compose.
 */
class MainActivity : ComponentActivity() {

    // Se utiliza una API experimental para manejar tamaños de ventana adaptables
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita el modo de diseño de borde a borde en dispositivos modernos
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        // Define el contenido visual usando Compose
        setContent {
            // Aplica el tema visual personalizado de la app
            ReplyTheme {
                val layoutDirection = LocalLayoutDirection.current // Dirección de lectura (LTR o RTL)

                // Crea un contenedor Surface con padding respetando los insets seguros (barra de estado, etc.)
                Surface(
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    // Calcula el tamaño de la ventana actual (Compact, Medium, Expanded)
                    val windowSize = calculateWindowSizeClass(this)

                    // Llama al componente principal de la app, pasándole el tipo de tamaño
                    ReplyApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

/**
 * Vista previa de la app en un dispositivo compacto (por ejemplo, teléfono en modo vertical).
 */
@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    ReplyTheme {
        Surface {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

/**
 * Vista previa de la app en un dispositivo mediano (por ejemplo, tablet en modo vertical o teléfono horizontal).
 */
@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppMediumPreview() {
    ReplyTheme {
        Surface {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
    }
}

/**
 * Vista previa de la app en un dispositivo expandido (por ejemplo, tablet grande o escritorio).
 */
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppExpandedPreview() {
    ReplyTheme {
        Surface {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
    }
}
