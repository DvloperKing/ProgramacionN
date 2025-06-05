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

package com.example.cupcake.data // Paquete que contiene las estructuras de datos compartidas entre capas de la app

/**
 * Clase de datos (data class) que representa el estado actual del pedido en la interfaz de usuario.
 * Esta estructura es inmutable y se usa comúnmente con State Hoisting en Jetpack Compose.
 *
 * Contiene la información seleccionada por el usuario hasta el momento: cantidad, sabor, fecha
 * y precio, así como las fechas disponibles para recogida.
 */
data class OrderUiState(
    /** Cantidad seleccionada de cupcakes (por ejemplo: 1, 6, 12). */
    val quantity: Int = 0,

    /** Sabor elegido para los cupcakes (ej. "Chocolate", "Vanilla"). */
    val flavor: String = "",

    /** Fecha seleccionada para la recogida del pedido (ej. "Jan 1"). */
    val date: String = "",

    /** Precio total del pedido como string con formato (ej. "$24"). */
    val price: String = "",

    /** Lista de fechas posibles para la recogida del pedido. */
    val pickupOptions: List<String> = listOf()
)
