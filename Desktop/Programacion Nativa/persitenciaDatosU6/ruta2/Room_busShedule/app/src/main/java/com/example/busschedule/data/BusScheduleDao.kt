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

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Interfaz DAO (Data Access Object) que define métodos para acceder a la base de datos Room.
 *
 * Esta interfaz contiene las consultas (queries) que permiten leer datos de la tabla "schedule".
 * Los métodos devuelven un Flow de listas, lo que permite observar los datos en tiempo real.
 */
@Dao
interface BusScheduleDao {

    /**
     * Obtiene todos los registros de la tabla "schedule", ordenados por hora de llegada (ascendente).
     *
     * @return Un flujo reactivo con la lista completa de paradas de autobús.
     */
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
    fun getAll(): Flow<List<BusSchedule>>

    /**
     * Obtiene los registros filtrados por nombre de parada, ordenados por hora de llegada (ascendente).
     *
     * @param stopName El nombre de la parada a buscar.
     * @return Un flujo reactivo con la lista de paradas que coinciden con el nombre.
     */
    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
