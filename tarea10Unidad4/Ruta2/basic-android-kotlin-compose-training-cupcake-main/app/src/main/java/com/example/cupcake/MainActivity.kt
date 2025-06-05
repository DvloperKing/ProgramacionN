/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo salvo cumpliendo con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, expresas o implícitas.
 */

package com.example.cupcake // Paquete base de la aplicación

// Importaciones necesarias para la actividad principal y Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Actividad principal de la aplicación.
 * Es el punto de entrada para lanzar la interfaz de usuario usando Jetpack Compose.
 */
class MainActivity : ComponentActivity() {

    /**
     * Método llamado al crear la actividad.
     * Aquí se configura el contenido de la app con Compose y se aplica el tema.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Habilita el diseño hasta los bordes (útil para pantallas con notch o barra de navegación)
        enableEdgeToEdge()

        // Llama al método onCreate de la superclase
        super.onCreate(savedInstanceState)

        // Define el contenido de la actividad usando Jetpack Compose
        setContent {
            // Aplica el tema Cupcake personalizado
            CupcakeTheme {
                // Muestra la aplicación Cupcake, que contiene la navegación y las pantallas
                CupcakeApp()
            }
        }
    }
}
