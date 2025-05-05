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

package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleDao
import kotlinx.coroutines.flow.Flow

/**
 * ViewModel para la app de horario de autobuses.
 *
 * Esta clase permite a la UI acceder a los datos de la base de datos Room de forma segura y reactiva.
 * Utiliza el DAO para recuperar los horarios completos o filtrados por parada.
 */
class BusScheduleViewModel(private val busScheduleDao: BusScheduleDao): ViewModel() {

    /**
     * Obtiene todos los registros del horario de autobuses desde la base de datos.
     *
     * @return Un Flow reactivo con una lista de horarios.
     */
    fun getFullSchedule(): Flow<List<BusSchedule>> = busScheduleDao.getAll()

    /**
     * Obtiene los horarios de autobuses filtrados por nombre de parada.
     *
     * @param stopName El nombre de la parada.
     * @return Un Flow reactivo con una lista de horarios correspondientes a esa parada.
     */
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        busScheduleDao.getByStopName(stopName)

    companion object {
        /**
         * Proveedor de fábrica para crear instancias del ViewModel con acceso a la base de datos.
         *
         * Usa la aplicación personalizada para obtener la instancia del DAO y pasarla al ViewModel.
         */
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BusScheduleApplication)
                BusScheduleViewModel(application.database.busScheduleDao())
            }
        }
    }
}
