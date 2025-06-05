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

package com.example.cupcake.test // Paquete de pruebas de la app "cupcake", donde se agrupan las utilidades de testing

import androidx.activity.ComponentActivity // Importa la clase base para actividades con soporte a Jetpack Compose
import androidx.annotation.StringRes // Anotación para indicar que un parámetro es un recurso de tipo string (R.string.algo)
import androidx.compose.ui.test.SemanticsNodeInteraction // Representa un nodo accesible en el árbol semántico usado en pruebas de UI
import androidx.compose.ui.test.junit4.AndroidComposeTestRule // Regla de prueba específica para Jetpack Compose y JUnit4
import androidx.compose.ui.test.onNodeWithText // Finder que localiza un nodo por texto visible
import androidx.test.ext.junit.rules.ActivityScenarioRule // Regla JUnit para lanzar y manejar el ciclo de vida de una actividad para pruebas

/**
 * Función de extensión para AndroidComposeTestRule que busca un nodo semántico usando un ID de recurso de string.
 *
 * Justificación:
 * La función estándar [onNodeWithText] no permite pasar directamente un ID de recurso (`@StringRes`).
 * Esta función obtiene el string a partir del ID usando la `activity` del test, y luego usa ese texto como entrada.
 *
 * @param id ID del recurso string (ej. R.string.example_label)
 * @return SemanticsNodeInteraction con el nodo encontrado que contiene el texto equivalente al recurso.
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int // Parámetro anotado para indicar que debe ser un recurso de tipo string
): SemanticsNodeInteraction = onNodeWithText(activity.getString(id)) 
// Convierte el ID de string en su valor textual real y lo pasa a onNodeWithText para buscar el nodo correspondiente
