/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo exija o se acuerde por escrito, este archivo
 * se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Actividad principal de la aplicación Cupcake.
 *
 * Esta clase extiende [ComponentActivity] y actúa como punto de entrada de la app.
 * Se encarga de establecer el contenido usando Jetpack Compose y aplicar el tema visual.
 */
class MainActivity : ComponentActivity() {

    /**
     * Método que se llama cuando la actividad es creada.
     *
     * Se habilita el diseño de borde a borde (sin barras de navegación visibles)
     * y se establece la UI definida por `CupcakeApp()` dentro del tema `CupcakeTheme`.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Activa diseño edge-to-edge (contenido puede ir detrás de la barra de estado/nav)
        enableEdgeToEdge()

        // Llama al ciclo de vida normal de la actividad
        super.onCreate(savedInstanceState)

        // Establece el contenido de la interfaz de usuario usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado Cupcake (colores, tipografía, etc.)
            CupcakeTheme {
                // Llama a la función composable principal de la app
                CupcakeApp()
            }
        }
    }
}
