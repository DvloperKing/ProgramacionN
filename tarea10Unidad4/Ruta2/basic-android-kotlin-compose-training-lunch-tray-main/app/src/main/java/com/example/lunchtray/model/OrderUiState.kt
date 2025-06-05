/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo exija o se acuerde por escrito, este archivo
 * se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.lunchtray.model

/**
 * Clase de datos que representa el estado actual de la orden de almuerzo.
 *
 * Esta clase contiene la selección del usuario (entrada, guarnición, acompañamiento),
 * así como el precio total de los artículos, impuestos calculados y total con impuestos incluidos.
 *
 * Se usa como `UiState` para que el ViewModel o componentes composables puedan observar y actualizar
 * el estado de forma reactiva.
 */
data class OrderUiState(
    // Ítem seleccionado como entrada (Entree)
    val entree: MenuItem.EntreeItem? = null,

    // Ítem seleccionado como guarnición (Side dish)
    val sideDish: MenuItem.SideDishItem? = null,

    // Ítem seleccionado como acompañamiento (Accompaniment)
    val accompaniment: MenuItem.AccompanimentItem? = null,

    // Precio total de los artículos seleccionados (sin impuestos)
    val itemTotalPrice: Double = 0.0,

    // Impuesto calculado sobre la orden
    val orderTax: Double = 0.0,

    // Precio total incluyendo impuestos
    val orderTotalPrice: Double = 0.0
)
