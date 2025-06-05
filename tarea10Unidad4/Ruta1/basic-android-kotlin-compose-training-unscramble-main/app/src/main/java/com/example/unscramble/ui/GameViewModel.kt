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

// Paquete que contiene los elementos de la interfaz del juego.
package com.example.unscramble.ui

// Importaciones necesarias para el manejo del estado y el modelo de vista.
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel que contiene los datos del juego y métodos para su lógica.
 * Se encarga de controlar el estado y manejar las acciones del usuario.
 */
class GameViewModel : ViewModel() {

    // Flujo mutable del estado de la UI, privado para modificación interna.
    private val _uiState = MutableStateFlow(GameUiState())
    // Exposición pública del estado como solo lectura (StateFlow).
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // Adivinanza del usuario en tiempo real, gestionada con Compose.
    var userGuess by mutableStateOf("")
        private set

    // Conjunto de palabras ya utilizadas para evitar repeticiones.
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String // Palabra actual a adivinar.

    // Bloque de inicialización que reinicia el juego cuando se crea el ViewModel.
    init {
        resetGame()
    }

    /**
     * Reinicia los datos del juego para comenzar una nueva partida.
     */
    fun resetGame() {
        usedWords.clear() // Limpia las palabras usadas
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    /**
     * Actualiza la adivinanza del usuario.
     * @param guessedWord La palabra ingresada por el jugador.
     */
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /**
     * Verifica si la adivinanza del usuario es correcta.
     * Si lo es, actualiza el puntaje y avanza el juego.
     */
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // Si es correcta, aumenta el puntaje y actualiza el estado
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
            // Si es incorrecta, se activa la bandera de error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Limpia la adivinanza del usuario
        updateUserGuess("")
    }

    /**
     * Salta a la siguiente palabra sin sumar puntos.
     */
    fun skipWord() {
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }

    /**
     * Actualiza el estado del juego con una nueva palabra y puntaje actualizado.
     * Si ya se usaron todas las palabras, finaliza el juego.
     * @param updatedScore Nuevo puntaje del jugador.
     */
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            // Si se llegó al número máximo de palabras, se termina el juego
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            // Ronda normal del juego: prepara siguiente palabra
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    /**
     * Revuelve las letras de una palabra recibida hasta que el resultado sea distinto.
     * @param word Palabra original sin mezclar.
     * @return Palabra revuelta.
     */
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle() // Mezcla las letras aleatoriamente
        while (String(tempWord) == word) {
            tempWord.shuffle() // Reintenta si queda igual
        }
        return String(tempWord)
    }

    /**
     * Selecciona una palabra al azar de la lista y la revuelve.
     * Evita repetir palabras ya utilizadas.
     * @return Palabra revuelta nueva.
     */
    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random() // Toma una palabra aleatoria
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle() // Si ya fue usada, intenta otra
        } else {
            usedWords.add(currentWord) // Registra palabra como usada
            shuffleCurrentWord(currentWord) // Devuelve la palabra revuelta
        }
    }
}
