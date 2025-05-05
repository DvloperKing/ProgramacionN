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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Clase que representa la base de datos local de la aplicación.
 *
 * Esta base de datos contiene una sola entidad: BusSchedule.
 * Se inicializa a partir de un archivo `.db` precargado ubicado en assets/database.
 * Room se encarga de mapear las clases Kotlin a tablas en SQLite automáticamente.
 */
@Database(entities = [BusSchedule::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Método abstracto que expone el DAO para acceder a los datos de la tabla "schedule".
     */
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        // Instancia única de la base de datos, visible para todo el proyecto.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Método para obtener una instancia singleton de la base de datos.
         * Si no existe, se crea usando un archivo de base de datos precargado.
         *
         * @param context El contexto de la aplicación.
         * @return Instancia de AppDatabase.
         */
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database" // Nombre del archivo de base de datos interna
                )
                    // Se carga desde el archivo de assets: assets/database/bus_schedule.db
                    .createFromAsset("database/bus_schedule.db")

                    // Esta opción elimina y reconstruye la base si hay cambios de versión sin migración
                    .fallbackToDestructiveMigration()

                    // Se construye y guarda la instancia para usos posteriores
                    .build().also {
                        INSTANCE = it
                    }
            }
        }
    }
}
