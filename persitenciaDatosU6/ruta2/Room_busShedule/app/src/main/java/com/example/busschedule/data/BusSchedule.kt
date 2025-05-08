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

package com.example.busschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de datos que representa una entidad en la base de datos Room.
 *
 * Esta entidad se asigna a la tabla "Schedule" en la base de datos local.
 * Cada instancia de esta clase representa una fila de esa tabla.
 *
 * @property id Identificador único de la parada. Es la clave primaria.
 * @property stopName Nombre de la parada de autobús (no puede ser nulo).
 * @property arrivalTimeInMillis Hora de llegada del autobús en formato Unix (milisegundos).
 */
@Entity(tableName = "Schedule")
data class BusSchedule(
    // Clave primaria sin autogeneración, ya que el archivo .db precargado ya trae los IDs definidos.
    @PrimaryKey val id: Int,

    // Nombre de la parada. Se guarda en la columna "stop_name".
    @NonNull @ColumnInfo(name = "stop_name") val stopName: String,

    // Hora de llegada. Se guarda en la columna "arrival_time" en formato entero (timestamp).
    @NonNull @ColumnInfo(name = "arrival_time") val arrivalTimeInMillis: Int
)
