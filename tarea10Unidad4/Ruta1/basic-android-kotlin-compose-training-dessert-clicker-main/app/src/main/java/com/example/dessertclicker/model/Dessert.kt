/*
 * Copyright (C) 2023 The Android Open Source Project
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

// Define el paquete donde se encuentra este modelo: "model" sugiere que contiene clases de datos (data classes).
package com.example.dessertclicker.model

/**
 * Clase de datos que representa un postre en el juego.
 *
 * @param imageId ID del recurso drawable que representa visualmente el postre.
 * @param price Precio en "dinero del juego" que se obtiene al vender este postre.
 * @param startProductionAmount Número mínimo de postres vendidos antes de que este postre comience a aparecer.
 *
 * Se utiliza para mostrar dinámicamente los postres en función del progreso del jugador.
 */
data class Dessert(
    val imageId: Int,              // ID del recurso de imagen (ej. R.drawable.donut)
    val price: Int,                // Precio del postre cuando se vende
    val startProductionAmount: Int // Umbral de postres vendidos necesarios para desbloquear este postre
)
