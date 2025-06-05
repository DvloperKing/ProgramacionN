/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo salvo en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, expresas o implícitas.
 */
package com.example.cupcake.data // Define el paquete donde se encuentra esta clase (lógica de datos)

/**
 * Clase de datos que representa el estado actual de la interfaz de usuario (UI) en términos de:
 * - cantidad de pastelitos
 * - sabor seleccionado
 * - fecha de recogida seleccionada
 * - lista de fechas disponibles para recoger
 * - precio total del pedido
 */
data class OrderUiState(
    /** Cantidad de pastelitos seleccionada (por ejemplo: 1, 6, 12) */
    val quantity: Int = 0,

    /** Sabor de los pastelitos en el pedido (por ejemplo: "Chocolate", "Vainilla", etc.) */
    val flavor: String = "",

    /** Fecha seleccionada para recoger el pedido (por ejemplo: "1 de enero") */
    val date: String = "",

    /** Precio total del pedido, representado como cadena formateada (por ejemplo: "$10.00") */
    val price: String = "",

    /** Lista de fechas disponibles para recoger el pedido */
    val pickupOptions: List<String> = listOf()
)
