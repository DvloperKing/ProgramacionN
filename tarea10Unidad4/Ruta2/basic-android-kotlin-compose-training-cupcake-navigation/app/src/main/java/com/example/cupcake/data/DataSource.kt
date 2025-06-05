/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo salvo cumpliendo con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, expresas o implícitas.
 */

package com.example.cupcake.data // Paquete que agrupa la fuente de datos usada en la app

import com.example.cupcake.R // Importa referencias a recursos (strings definidos en res/values/strings.xml)

object DataSource {
    // Lista de sabores disponibles, usando referencias a recursos de string (para soporte multilenguaje)
    val flavors = listOf(
        R.string.vanilla,          // Vainilla
        R.string.chocolate,        // Chocolate
        R.string.red_velvet,       // Red Velvet
        R.string.salted_caramel,   // Caramelo salado
        R.string.coffee            // Café
    )

    // Opciones de cantidad disponibles para el pedido, cada una con una etiqueta y un número
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),     // 1 pastelito
        Pair(R.string.six_cupcakes, 6),    // 6 pastelitos
        Pair(R.string.twelve_cupcakes, 12) // 12 pastelitos
    )
}
