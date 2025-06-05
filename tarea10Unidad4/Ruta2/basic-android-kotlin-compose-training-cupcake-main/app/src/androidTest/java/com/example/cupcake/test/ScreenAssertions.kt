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

package com.example.cupcake.test // Paquete que agrupa utilidades y extensiones para pruebas

import androidx.navigation.NavController // Importa el controlador de navegación de Jetpack Navigation
import org.junit.Assert // Importa herramientas de aserción para pruebas unitarias

/**
 * Función de extensión para [NavController] que verifica que la ruta actual del back stack
 * sea igual a la esperada. Útil para validar la navegación entre pantallas en pruebas instrumentadas.
 *
 * @param expectedRouteName Nombre de la ruta (route) que se espera esté activa.
 * Ejemplo: "Start", "Flavor", "Pickup", "Summary"
 */
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    // Compara la ruta activa actual con la esperada usando assertEquals de JUnit
    Assert.assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}
