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

package com.example.reply.test // Paquete de pruebas del proyecto Reply

// Importaciones necesarias para tests UI con Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.reply.R
import com.example.reply.data.local.LocalEmailsDataProvider
import com.example.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

/**
 * Clase de prueba que valida que la selección de un email se restaure correctamente
 * después de un cambio de configuración (como una rotación de pantalla).
 */
class ReplyAppStateRestorationTest {

    /**
     * Regla para lanzar una actividad vacía (`ComponentActivity`) necesaria para Compose UI tests.
     * No usa MainActivity para mantener la prueba aislada.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    /**
     * Prueba de restauración de estado en dispositivos con ancho compacto.
     * Valida que el email seleccionado siga siendo visible tras una recreación de la actividad.
     */
    @Test
    @TestCompactWidth // Anotación personalizada del entorno de prueba para simular pantalla compacta
    fun compactDevice_selectedEmailEmailRetained_afterConfigChange() {
        // Inicializa StateRestorationTester para simular restauración de estado
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        // Lanza la app en modo compacto
        stateRestorationTester.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }

        // Verifica que el cuerpo del tercer correo esté presente (previo a selección)
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
        ).assertIsDisplayed()

        // Simula clic sobre el asunto del tercer correo para abrir su detalle
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].subject)
        ).performClick()

        // Verifica que se haya abierto la pantalla detallada del email seleccionado
        composeTestRule.onNodeWithContentDescriptionForStringId(R.string.navigation_back)
            .assertExists()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
        ).assertExists()

        // Simula una recreación de la actividad (como rotación de pantalla)
        stateRestorationTester.emulateSavedInstanceStateRestore()

        // Verifica que el correo detallado aún se muestre después de restauración
        composeTestRule.onNodeWithContentDescriptionForStringId(R.string.navigation_back)
            .assertExists()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
        ).assertExists()
    }

    /**
     * Prueba de restauración de estado en dispositivos con pantalla expandida.
     * Verifica que el correo seleccionado permanezca visible en el panel de detalle.
     */
    @Test
    @TestExpandedWidth // Anotación personalizada del entorno de prueba para modo pantalla expandida
    fun expandedDevice_selectedEmailEmailRetained_afterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        // Lanza la app con pantalla ancha
        stateRestorationTester.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        // Verifica que el cuerpo del tercer correo esté visible inicialmente
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
        ).assertIsDisplayed()

        // Simula selección del tercer email por su asunto
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].subject)
        ).performClick()

        // Verifica que el cuerpo del email aparezca en la pantalla de detalles
        composeTestRule.onNodeWithTagForStringId(R.string.details_screen).onChildren()
            .assertAny(
                hasAnyDescendant(
                    hasText(composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body))
                )
            )

        // Simula cambio de configuración
        stateRestorationTester.emulateSavedInstanceStateRestore()

        // Verifica que el contenido del email siga visible en la pantalla de detalles
        composeTestRule.onNodeWithTagForStringId(R.string.details_screen).onChildren()
            .assertAny(
                hasAnyDescendant(
                    hasText(composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body))
                )
            )
    }
}
