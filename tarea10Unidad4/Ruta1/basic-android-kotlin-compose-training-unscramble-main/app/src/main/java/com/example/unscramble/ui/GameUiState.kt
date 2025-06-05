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

// Paquete al que pertenece esta clase. Define la ubicación dentro del proyecto.
package com.example.unscramble.ui

/**
 * Clase de datos que representa el estado actual de la interfaz de usuario del juego Unscramble.
 * Se utiliza para almacenar y observar los datos que componen el juego.
 *
 * @property currentScrambledWord Palabra mezclada actual que el usuario debe adivinar.
 * @property currentWordCount Número de palabras mostradas hasta el momento en la partida.
 * @property score Puntaje actual del jugador.
 * @property isGuessedWordWrong Indica si el intento más reciente fue incorrecto.
 * @property isGameOver Indica si el juego ha finalizado.
 */
data class GameUiState(
    val currentScrambledWord: String = "", // Palabra mezclada a adivinar, inicializada como cadena vacía.
    val currentWordCount: Int = 1,         // Contador de palabras jugadas, comienza en 1.
    val score: Int = 0,                    // Puntuación del usuario, comienza en 0.
    val isGuessedWordWrong: Boolean = false, // Bandera que indica si el usuario se equivocó.
    val isGameOver: Boolean = false         // Bandera que indica si el juego ha terminado.
)
