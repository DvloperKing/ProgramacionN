/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Paquete que agrupa las clases relacionadas con los datos de la app
package com.example.dessertclicker.data

// Importa los recursos gráficos (R.drawable) y el modelo de datos Dessert
import com.example.dessertclicker.R
import com.example.dessertclicker.model.Dessert

/**
 * Objeto singleton que representa la fuente de datos de la aplicación.
 * Contiene una lista inmutable de postres, cada uno representado por la clase [Dessert].
 */
object Datasource {

    // Lista inmutable de postres, cada uno con:
    // - ID del recurso de imagen
    // - Precio al vender el postre
    // - Cantidad mínima de postres vendidos para que empiece a aparecer
    val dessertList = listOf(
        Dessert(R.drawable.cupcake, 5, 0),           // Aparece desde el inicio (0 vendidos)
        Dessert(R.drawable.donut, 10, 5),            // Aparece tras vender 5 postres
        Dessert(R.drawable.eclair, 15, 20),          // Aparece tras vender 20 postres
        Dessert(R.drawable.froyo, 30, 50),           // Aparece tras vender 50 postres
        Dessert(R.drawable.gingerbread, 50, 100),    // Aparece tras vender 100 postres
        Dessert(R.drawable.honeycomb, 100, 200),     // Aparece tras vender 200 postres
        Dessert(R.drawable.icecreamsandwich, 500, 500),      // Aparece tras vender 500 postres
        Dessert(R.drawable.jellybean, 1000, 1000),            // Aparece tras vender 1000 postres
        Dessert(R.drawable.kitkat, 2000, 2000),               // Aparece tras vender 2000 postres
        Dessert(R.drawable.lollipop, 3000, 4000),             // Aparece tras vender 4000 postres
        Dessert(R.drawable.marshmallow, 4000, 8000),          // Aparece tras vender 8000 postres
        Dessert(R.drawable.nougat, 5000, 16000),              // Aparece tras vender 16000 postres
        Dessert(R.drawable.oreo, 6000, 20000)                 // Último postre, aparece tras 20000 ventas
    )
}
