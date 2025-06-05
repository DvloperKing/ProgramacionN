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

package com.example.reply.test // Paquete de pruebas de la app Reply

// Importaciones necesarias para pruebas UI con Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.reply.R
import com.example.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

/**
 * Esta clase contiene pruebas para verificar que ReplyApp muestra el componente de navegación
 * correcto dependiendo del tamaño de ventana (compacto, mediano o expandido).
 */
class ReplyAppTest {

    /**
     * Regla de prueba para lanzar una actividad vacía que pueda alojar contenido Compose.
     * Se utiliza `ComponentActivity` en lugar de `MainActivity` para mantener la prueba aislada.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    /**
     * Prueba que valida que en pantallas compactas se use navegación inferior (Bottom Navigation).
     */
    @Test
    @TestCompactWidth // Anotación personalizada que simula un dispositivo compacto (por ej. smartphone)
    fun compactDevice_verifyUsingBottomNavigation() {
        // Configura el contenido con tamaño de ventana compacto
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }

        // Verifica que el componente de navegación inferior esté presente
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()
    }

    /**
     * Prueba que valida que en pantallas medianas se use Navigation Rail (barra lateral).
     */
    @Test
    @TestMediumWidth // Simula un dispositivo de ancho mediano (por ejemplo, tablet vertical)
    fun mediumDevice_verifyUsingNavigationRail() {
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Medium)
        }

        // Verifica que el Navigation Rail esté presente
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    /**
     * Prueba que valida que en pantallas expandidas se use el Navigation Drawer (menú lateral completo).
     */
    @Test
    @TestExpandedWidth // Simula dispositivo con pantalla amplia (ej. tablet horizontal o Chromebook)
    fun expandedDevice_verifyUsingNavigationDrawer() {
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        // Verifica que el Navigation Drawer esté presente
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }
}
