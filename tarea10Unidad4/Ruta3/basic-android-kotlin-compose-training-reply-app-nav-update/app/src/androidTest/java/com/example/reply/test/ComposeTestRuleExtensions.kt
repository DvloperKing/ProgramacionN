/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define funciones auxiliares para pruebas de interfaz de usuario con Jetpack Compose.
 * Facilita la búsqueda de nodos mediante recursos string (R.string) en pruebas automatizadas.
 */

package com.example.reply.test

// Importaciones necesarias para pruebas con Compose y acceso a recursos
import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule

/**
 * Extensión personalizada que permite encontrar un nodo por texto utilizando un ID de recurso de cadena.
 *
 * Por defecto, `onNodeWithText()` no acepta `@StringRes`.
 * Esta función extrae el string a través de la actividad y lo pasa al método estándar.
 *
 * @param id ID del recurso string (ej. R.string.nombre)
 * @return Nodo Semántico correspondiente al texto
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithText(activity.getString(id))

/**
 * Extensión personalizada que permite encontrar un nodo por contentDescription usando un ID de recurso de cadena.
 *
 * Jetpack Compose no permite usar `@StringRes` directamente en `onNodeWithContentDescription()`.
 * Esta función accede a la cadena usando `activity.getString()` y la pasa al método.
 *
 * @param id ID del recurso string usado en la descripción del contenido
 * @return Nodo Semántico correspondiente a la descripción
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>
        .onNodeWithContentDescriptionForStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithContentDescription(activity.getString(id))

/**
 * Extensión personalizada que permite encontrar un nodo por su testTag utilizando un recurso de cadena.
 *
 * Jetpack Compose no permite usar `@StringRes` directamente en `onNodeWithTag()`.
 * Esta función convierte el recurso en texto con `getString()` y lo usa como tag.
 *
 * @param id ID del recurso string usado como testTag
 * @return Nodo Semántico correspondiente al tag
 */
fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>
        .onNodeWithTagForStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithTag(activity.getString(id))
