/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
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

package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.AppDatabase

/**
 * Clase Application personalizada de la app.
 *
 * Se utiliza para inicializar recursos globales al inicio de la aplicación.
 * Aquí se crea una instancia única (singleton) de la base de datos Room,
 * accesible desde cualquier parte de la app.
 */
class BusScheduleApplication : Application() {

    /**
     * Instancia de la base de datos que se inicializa una única vez (lazy).
     * Esto permite acceder al DAO desde los ViewModel sin necesidad de múltiples construcciones.
     */
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
