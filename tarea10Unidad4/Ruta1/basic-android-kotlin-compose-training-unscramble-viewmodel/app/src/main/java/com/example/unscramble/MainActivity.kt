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

package com.example.unscramble // Define el paquete donde reside esta clase; ayuda a organizar y agrupar el código del proyecto

import android.os.Bundle // Importa la clase Bundle usada para restaurar el estado anterior de la actividad
import androidx.activity.ComponentActivity // Actividad base para apps que usan Jetpack Compose
import androidx.activity.compose.setContent // Función para establecer la interfaz de usuario basada en Compose
import androidx.activity.enableEdgeToEdge // Permite dibujar detrás de las barras del sistema (barra de estado y navegación)

import androidx.compose.foundation.layout.fillMaxSize // Modificador que hace que un componente use todo el espacio disponible
import androidx.compose.material3.Surface // Contenedor de Material Design 3 que aplica color de fondo, elevación, etc.
import androidx.compose.ui.Modifier // Objeto que permite aplicar modificaciones de presentación a composables

import com.example.unscramble.ui.GameScreen // Importa el composable GameScreen que representa la pantalla principal del juego
import com.example.unscramble.ui.theme.UnscrambleTheme // Importa el tema personalizado de la aplicación

// Clase principal de la aplicación que extiende de ComponentActivity, necesaria para usar Jetpack Compose
class MainActivity : ComponentActivity() {
    // Método de ciclo de vida llamado cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Permite que la UI se extienda a las áreas detrás de las barras del sistema
        super.onCreate(savedInstanceState) // Llama al método onCreate de la superclase para inicializar la actividad

        setContent {
            // Establece el contenido visual de la actividad utilizando Jetpack Compose
            UnscrambleTheme {
                // Aplica el tema de la app a todos los componentes hijos
                Surface(
                    modifier = Modifier.fillMaxSize(), // Hace que el Surface ocupe todo el tamaño de la pantalla
                ) {
                    GameScreen() // Llama al composable que contiene la lógica y visualización del juego
                }
            }
        }
    }
}
