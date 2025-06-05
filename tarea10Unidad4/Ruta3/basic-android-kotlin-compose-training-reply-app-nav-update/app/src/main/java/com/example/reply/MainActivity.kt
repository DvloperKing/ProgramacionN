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
package com.example.reply // Paquete base de la app

// Importaciones necesarias para la actividad y el entorno Compose
import android.os.Bundle
import androidx.activity.ComponentActivity // Actividad base compatible con Jetpack Compose
import androidx.activity.compose.setContent // Permite establecer el contenido de la UI en Compose
import androidx.activity.enableEdgeToEdge // Habilita modo inmersivo, para usar toda la pantalla
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing // Inset que evita que el contenido quede bajo áreas inseguras
import androidx.compose.material3.Surface // Contenedor de fondo con color y elevación
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass // Enum para clasificar el tamaño horizontal de pantalla
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass // Calcula la clase de tamaño de ventana actual
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection // Proporciona información sobre la dirección de diseño (LTR o RTL)
import androidx.compose.ui.tooling.preview.Preview // Permite previsualizar en el editor de Compose
import com.example.reply.ui.ReplyApp // Importa el composable principal de la aplicación
import com.example.reply.ui.theme.ReplyTheme // Importa el tema de la aplicación

// Clase principal de la app que extiende de ComponentActivity
class MainActivity : ComponentActivity() {

    // Anotación para indicar que usamos una API experimental de tamaño de ventana
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita la utilización completa de la pantalla (oculta barras del sistema)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Establece el contenido usando Jetpack Compose
        setContent {
            // Aplica el tema visual definido para la app
            ReplyTheme {
                // Obtiene la dirección de diseño actual (importante para padding correcto)
                val layoutDirection = LocalLayoutDirection.current

                // Surface actúa como fondo principal de la app, respetando márgenes seguros
                Surface(
                    modifier = Modifier
                        .padding(
                            // Aplica padding de acuerdo al inicio de pantalla, considerando RTL o LTR
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            // Aplica padding al final de la pantalla, también sensible a dirección
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    // Calcula el tamaño de ventana (compacto, mediano, expandido) en tiempo de ejecución
                    val windowSize = calculateWindowSizeClass(this)
                    // Lanza la aplicación principal con el tamaño de ventana detectado
                    ReplyApp(
                        windowSize = windowSize.widthSizeClass,
                    )
                }
            }
        }
    }
}

// Composable de vista previa para mostrar cómo se verá la app en un dispositivo compacto
@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    // Aplica el tema visual también en la vista previa
    ReplyTheme {
        // Surface para fondo con estilos visuales aplicados
        Surface {
            // Renderiza la app como si fuera en pantalla compacta (ej. teléfono)
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact,
            )
        }
    }
}
