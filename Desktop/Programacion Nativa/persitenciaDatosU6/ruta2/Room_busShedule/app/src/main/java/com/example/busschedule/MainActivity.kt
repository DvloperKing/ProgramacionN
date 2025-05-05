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

package com.example.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.busschedule.ui.BusScheduleApp
import com.example.busschedule.ui.theme.BusScheduleTheme

/**
 * Actividad principal (MainActivity) que se ejecuta al iniciar la app.
 *
 * Aquí se establece el contenido de la interfaz utilizando Jetpack Compose
 * y se aplica el tema personalizado de la aplicación.
 */
class MainActivity : ComponentActivity() {

    /**
     * Método que se ejecuta al crear la actividad.
     * Se encarga de establecer la interfaz con el Composable BusScheduleApp.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el contenido visual usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado definido en ui.theme
            BusScheduleTheme {
                // Llama al Composable principal que gestiona toda la navegación
                BusScheduleApp()
            }
        }
    }
}
