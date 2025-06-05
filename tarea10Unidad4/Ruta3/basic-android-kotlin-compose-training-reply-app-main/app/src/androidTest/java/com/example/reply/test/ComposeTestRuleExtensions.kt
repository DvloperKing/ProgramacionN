/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
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

package com.example.reply.test // Paquete de pruebas del proyecto Reply (u otro similar)

// Importaciones necesarias para testing con Jetpack Compose
import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule

/**
 * Función de extensión para facilitar pruebas: encuentra un nodo composable por ID de string.
 *
 * Esta función permite usar un recurso `@StringRes` directamente en lugar de hardcodear texto.
 * @param id ID del recurso de texto que se desea buscar.
 * @return [SemanticsNodeInteraction] correspondiente al nodo que contiene el texto.
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithText(activity.getString(id)) // Convierte el ID a texto y busca el nodo

/**
 * Función de extensión para encontrar un nodo usando contentDescription basado en ID de string.
 *
 * Ideal para pruebas de accesibilidad y botones con `contentDescription`.
 * @param id ID del recurso string usado como contentDescription.
 * @return [SemanticsNodeInteraction] del nodo con ese contentDescription.
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>
        .onNodeWithContentDescriptionForStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithContentDescription(activity.getString(id))

/**
 * Función de extensión para encontrar un nodo usando un testTag definido por un ID de string.
 *
 * Útil para pruebas que identifican nodos por etiquetas de prueba (`Modifier.testTag(...)`).
 * @param id ID del recurso string usado como test tag.
 * @return [SemanticsNodeInteraction] del nodo con ese test tag.
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>
        .onNodeWithTagForStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithTag(activity.getString(id))
