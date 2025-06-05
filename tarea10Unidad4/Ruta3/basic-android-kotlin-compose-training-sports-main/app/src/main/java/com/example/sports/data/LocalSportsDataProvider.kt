/*
 * Copyright (C) 2023 The Android Open Source Project
 * 
 * Licencia Apache 2.0: Este archivo puede utilizarse conforme a los términos de dicha licencia.
 * Ver: https://www.apache.org/licenses/LICENSE-2.0
 * 
 * El archivo se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.sports.data // Paquete que contiene clases de acceso a datos del módulo Sports

import com.example.sports.R // Importa los recursos del proyecto (strings e imágenes)
import com.example.sports.model.Sport // Importa el modelo de datos Sport

/**
 * Objeto singleton que simula una fuente de datos local para deportes.
 */
object LocalSportsDataProvider {
    
    // Define un deporte por defecto (el primero de la lista generada)
    val defaultSport = getSportsData()[0]

    /**
     * Retorna una lista estática de deportes, cada uno instanciado con sus propiedades.
     * Estas entradas actúan como base de datos simulada para pruebas o desarrollo sin backend.
     */
    fun getSportsData(): List<Sport> {
        return listOf(
            // Cada objeto Sport contiene identificador, referencias a recursos, número de jugadores, etc.
            Sport(
                id = 1,
                titleResourceId = R.string.baseball,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 9, // Número típico de jugadores por equipo en béisbol
                olympic = true,
                imageResourceId = R.drawable.ic_baseball_square,
                sportsImageBanner = R.drawable.ic_baseball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 2,
                titleResourceId = R.string.badminton,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_badminton_square,
                sportsImageBanner = R.drawable.ic_badminton_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 3,
                titleResourceId = R.string.basketball,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 5,
                olympic = true,
                imageResourceId = R.drawable.ic_basketball_square,
                sportsImageBanner = R.drawable.ic_basketball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 4,
                titleResourceId = R.string.bowling,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = false, // No es deporte olímpico
                imageResourceId = R.drawable.ic_bowling_square,
                sportsImageBanner = R.drawable.ic_bowling_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 5,
                titleResourceId = R.string.cycling,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_cycling_square,
                sportsImageBanner = R.drawable.ic_cycling_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 6,
                titleResourceId = R.string.golf,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = false,
                imageResourceId = R.drawable.ic_golf_square,
                sportsImageBanner = R.drawable.ic_golf_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 7,
                titleResourceId = R.string.running,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_running_square,
                sportsImageBanner = R.drawable.ic_running_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 8,
                titleResourceId = R.string.soccer,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 11,
                olympic = true,
                imageResourceId = R.drawable.ic_soccer_square,
                sportsImageBanner = R.drawable.ic_soccer_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 9,
                titleResourceId = R.string.swimming,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_swimming_square,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 10,
                titleResourceId = R.string.table_tennis,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_table_tennis_square,
                sportsImageBanner = R.drawable.ic_table_tennis_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 11,
                titleResourceId = R.string.tennis,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.ic_tennis_square,
                sportsImageBanner = R.drawable.ic_tennis_banner,
                sportDetails = R.string.sport_detail_text
            )
        )
    }
}
