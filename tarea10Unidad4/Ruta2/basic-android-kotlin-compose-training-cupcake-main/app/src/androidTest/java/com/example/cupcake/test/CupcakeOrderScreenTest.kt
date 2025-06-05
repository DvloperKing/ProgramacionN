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

package com.example.cupcake.test // Paquete de pruebas de la aplicación Cupcake

// Imports para componentes de pruebas y Compose UI
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

// Recursos y componentes de UI usados en las pruebas
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen

// Herramientas de pruebas de JUnit
import org.junit.Rule
import org.junit.Test

// Clase de pruebas automatizadas para pantallas Compose del flujo de pedido de pastelillos
class CupcakeOrderScreenTest {

    /**
     * Regla para ejecutar pruebas con una actividad vacía (ComponentActivity).
     * Esto permite montar composables en un entorno de prueba controlado.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // Objeto simulado de estado de UI para usar en pruebas de resumen de pedido
    private val fakeOrderUiState = OrderUiState(
        quantity = 6,
        flavor = "Vanilla",
        date = "Wed Jul 21",
        price = "$100",
        pickupOptions = listOf()
    )

    /**
     * Prueba: cuando se carga la pantalla StartOrderScreen,
     * todas las opciones de cantidad deben mostrarse correctamente.
     */
    @Test
    fun startOrderScreen_verifyContent() {

        // Renderiza el composable StartOrderScreen
        composeTestRule.setContent {
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions,
                onNextButtonClicked = {} // Acción vacía (no importa en esta prueba)
            )
        }

        // Verifica que cada opción (basada en los textos del recurso) esté visible
        DataSource.quantityOptions.forEach {
            composeTestRule.onNodeWithStringId(it.first).assertIsDisplayed()
        }
    }

    /**
     * Prueba: al renderizar SelectOptionScreen con una lista de opciones y subtotal,
     * se deben mostrar correctamente en pantalla y el botón de siguiente debe estar deshabilitado inicialmente.
     */
    @Test
    fun selectOptionScreen_verifyContent() {
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        val subtotal = "$100"

        // Renderiza SelectOptionScreen con los datos de prueba
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        // Verifica que todas las opciones de sabor se muestren
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        // Verifica que el subtotal se muestra correctamente usando recursos localizados
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        // El botón de siguiente (Next) debe estar deshabilitado hasta que se seleccione una opción
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    /**
     * Prueba: cuando se selecciona una opción en SelectOptionScreen,
     * el botón de siguiente (Next) debe habilitarse.
     */
    @Test
    fun selectOptionScreen_optionSelected_NextButtonEnabled() {
        val flavours = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        val subTotal = "$100"

        // Renderiza la pantalla con las opciones
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subTotal, options = flavours)
        }

        // Simula un clic sobre una de las opciones ("Vanilla")
        composeTestRule.onNodeWithText("Vanilla").performClick()

        // Verifica que el botón "Next" ahora esté habilitado
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    /**
     * Prueba: al mostrar OrderSummaryScreen con un estado de pedido,
     * los valores de sabor, fecha y subtotal deben estar correctamente representados.
     */
    @Test
    fun summaryScreen_verifyContentDisplay() {
        // Renderiza la pantalla de resumen con estado simulado
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = fakeOrderUiState,
                onCancelButtonClicked = {}, // Acción simulada
                onSendButtonClicked = { _, _ -> }, // Acción simulada
            )
        }

        // Verifica que los datos del estado se muestren en pantalla
        composeTestRule.onNodeWithText(fakeOrderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOrderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                fakeOrderUiState.price
            )
        ).assertIsDisplayed()
    }
}
