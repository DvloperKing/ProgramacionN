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

package com.example.cupcake.data // Paquete donde se almacena la lógica relacionada con los datos de la app

import com.example.cupcake.R // Importa los recursos definidos en res/values/strings.xml

/**
 * Objeto singleton que proporciona datos estáticos (hardcoded) utilizados en la interfaz de usuario.
 * Ideal para simular una fuente de datos real (como una base de datos o API remota) durante desarrollo y pruebas.
 */
object DataSource {

    /**
     * Lista de sabores disponibles para elegir, representados como IDs de recursos de string.
     * Esto permite el uso de internacionalización (traducción automática en otros idiomas).
     */
    val flavors = listOf(
        R.string.vanilla,         // "Vanilla"
        R.string.chocolate,       // "Chocolate"
        R.string.red_velvet,      // "Red Velvet"
        R.string.salted_caramel,  // "Salted Caramel"
        R.string.coffee           // "Coffee"
    )

    /**
     * Lista de opciones de cantidad que puede elegir el usuario al iniciar un pedido.
     * Cada elemento es un Pair donde:
     *  - el primer valor es un ID de recurso de string (ej. "1 cupcake"),
     *  - el segundo valor es el número entero correspondiente (ej. 1, 6, 12).
     */
    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )
}
