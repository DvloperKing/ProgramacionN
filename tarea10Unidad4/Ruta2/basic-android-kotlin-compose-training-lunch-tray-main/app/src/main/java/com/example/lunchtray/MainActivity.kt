/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lunchtray // Define el paquete base de esta clase (estructura de la app)

// Importaciones necesarias para actividades y Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity // Base para actividades que usan Compose
import androidx.activity.compose.setContent // Función que define el contenido composable de la actividad
import com.example.lunchtray.ui.theme.LunchTrayTheme // Tema personalizado de la app

/**
 * Actividad principal que se ejecuta al iniciar la app.
 * Extiende de ComponentActivity para integrar Jetpack Compose como sistema de UI.
 */
class MainActivity : ComponentActivity() {

    /**
     * Método de ciclo de vida llamado al crear la actividad.
     * Se encarga de configurar la interfaz de usuario mediante Jetpack Compose.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama a la implementación base del método onCreate

        // Establece el contenido de la pantalla usando un Composable
        setContent {
            // Aplica el tema personalizado definido en LunchTrayTheme.kt
            LunchTrayTheme {
                // Llama al Composable raíz de la app (estructura con navegación)
                LunchTrayApp()
            }
        }
    }
}
