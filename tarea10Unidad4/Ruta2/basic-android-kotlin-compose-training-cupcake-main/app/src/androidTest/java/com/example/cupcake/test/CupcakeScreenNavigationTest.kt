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

package com.example.cupcake.test // Paquete de pruebas de la app Cupcake

// Imports necesarios para pruebas de UI en Jetpack Compose y navegación
import android.icu.util.Calendar
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale

// Clase de pruebas de navegación para la app Cupcake
class CupcakeScreenNavigationTest {

    /**
     * Regla de Compose que lanza una actividad vacía para montar la UI de prueba.
     * En lugar de usar MainActivity, se utiliza ComponentActivity para mayor flexibilidad.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // Controlador de navegación usado para verificar rutas activas durante las pruebas
    private lateinit var navController: TestNavHostController

    /**
     * Configura el NavHostController antes de cada prueba.
     * Inicializa el navController con un navegador de Compose y lo inyecta en CupcakeApp.
     */
    @Before
    fun setupCupcakeNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }

    /**
     * Verifica que la ruta de inicio al lanzar la app sea la pantalla Start.
     */
    @Test
    fun cupcakeNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /**
     * Verifica que no se muestre el botón de retroceso en la pantalla de inicio de pedido.
     */
    @Test
    fun cupcakeNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    /**
     * Al seleccionar un pastelillo, debe navegar a la pantalla de selección de sabor.
     */
    @Test
    fun cupcakeNavHost_clickOneCupcake_navigatesToSelectFlavorScreen() {
        composeTestRule.onNodeWithStringId(R.string.one_cupcake)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Flavor.name)
    }

    /**
     * Al hacer clic en "Siguiente" en la pantalla de sabor, debe navegar a la de recogida.
     */
    @Test
    fun cupcakeNavHost_clickNextOnFlavorScreen_navigatesToPickupScreen() {
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Pickup.name)
    }

    /**
     * Al hacer clic en "Atrás" en la pantalla de sabor, debe regresar a la pantalla de inicio.
     */
    @Test
    fun cupcakeNavHost_clickBackOnFlavorScreen_navigatesToStartOrderScreen() {
        navigateToFlavorScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /**
     * Al hacer clic en "Cancelar" en la pantalla de sabor, debe regresar a la pantalla de inicio.
     */
    @Test
    fun cupcakeNavHost_clickCancelOnFlavorScreen_navigatesToStartOrderScreen() {
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /**
     * Desde la pantalla de recogida, seleccionar una fecha y dar "Siguiente" debe llevar a resumen.
     */
    @Test
    fun cupcakeNavHost_clickNextOnPickupScreen_navigatesToSummaryScreen() {
        navigateToPickupScreen()
        composeTestRule.onNodeWithText(getFormattedDate())
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Summary.name)
    }

    /**
     * Al hacer clic en "Atrás" en la pantalla de recogida, se debe volver a la de sabor.
     */
    @Test
    fun cupcakeNavHost_clickBackOnPickupScreen_navigatesToFlavorScreen() {
        navigateToPickupScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(CupcakeScreen.Flavor.name)
    }

    /**
     * Al hacer clic en "Cancelar" en la pantalla de recogida, se debe volver a la de inicio.
     */
    @Test
    fun cupcakeNavHost_clickCancelOnPickupScreen_navigatesToStartOrderScreen() {
        navigateToPickupScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    /**
     * Al hacer clic en "Cancelar" en la pantalla de resumen, debe regresar al inicio.
     */
    @Test
    fun cupcakeNavHost_clickCancelOnSummaryScreen_navigatesToStartOrderScreen() {
        navigateToSummaryScreen()
        composeTestRule.onNodeWithStringId(R.string.cancel)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    // 🔽 Métodos auxiliares para reducir duplicación y facilitar pruebas

    /** Navega desde la pantalla de inicio hasta la pantalla de sabor. */
    private fun navigateToFlavorScreen() {
        composeTestRule.onNodeWithStringId(R.string.one_cupcake)
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.chocolate)
            .performClick()
    }

    /** Navega desde inicio hasta la pantalla de recogida. */
    private fun navigateToPickupScreen() {
        navigateToFlavorScreen()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
    }

    /** Navega desde inicio hasta la pantalla de resumen del pedido. */
    private fun navigateToSummaryScreen() {
        navigateToPickupScreen()
        composeTestRule.onNodeWithText(getFormattedDate())
            .performClick()
        composeTestRule.onNodeWithStringId(R.string.next)
            .performClick()
    }

    /** Ejecuta acción equivalente a pulsar el botón de retroceso. */
    private fun performNavigateUp() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }

    /** Devuelve la fecha de recogida formateada según el idioma local (ej. "Wed Jul 3"). */
    private fun getFormattedDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(java.util.Calendar.DATE, 1) // Siguiente día
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        return formatter.format(calendar.time)
    }
}
