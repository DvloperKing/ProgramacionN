/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package com.example.sports.model // Paquete donde se define el modelo de datos Sport

import androidx.annotation.DrawableRes // Anotación para validar recursos de tipo drawable
import androidx.annotation.StringRes   // Anotación para validar recursos de tipo string

/**
 * Modelo de datos que representa un deporte (Sport).
 * Esta clase se utiliza para estructurar la información que se muestra en la interfaz.
 */
data class Sport(
    val id: Int, // Identificador único del deporte
    @StringRes val titleResourceId: Int, // ID del recurso de string para el nombre del deporte
    @StringRes val subtitleResourceId: Int, // ID del recurso de string para el subtítulo
    val playerCount: Int, // Número típico de jugadores por equipo o participantes
    val olympic: Boolean, // Indica si el deporte es olímpico o no
    @DrawableRes val imageResourceId: Int, // ID del recurso drawable para el ícono en lista
    @DrawableRes val sportsImageBanner: Int, // ID del recurso drawable para imagen tipo banner
    @StringRes val sportDetails: Int // ID del recurso de string con la descripción del deporte
)
