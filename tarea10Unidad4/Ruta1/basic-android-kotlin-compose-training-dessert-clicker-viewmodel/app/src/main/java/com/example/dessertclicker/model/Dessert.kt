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

// Paquete que contiene los modelos de datos de la aplicación
package com.example.dessertclicker.model

/**
 * Clase de datos que representa un postre en el juego Dessert Clicker.
 *
 * @property imageId ID del recurso gráfico asociado al postre (ej. R.drawable.cupcake)
 * @property price Precio del postre en términos de "ganancia" dentro del juego
 * @property startProductionAmount Número mínimo de postres vendidos para que este postre aparezca
 *
 * Esta clase se utiliza en la lista de postres y determina cuál se debe mostrar
 * según la cantidad vendida en el juego.
 */
data class Dessert(
    val imageId: Int,              // Recurso drawable del postre
    val price: Int,                // Ganancia generada por este postre
    val startProductionAmount: Int // Umbral de aparición basado en postres vendidos
)
