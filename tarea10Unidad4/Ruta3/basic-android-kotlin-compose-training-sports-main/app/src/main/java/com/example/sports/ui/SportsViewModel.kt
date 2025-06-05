/*
 * Copyright (C) 2023 The Android Open Source Project
 * 
 * Licencia Apache 2.0: uso permitido bajo condiciones específicas.
 */

package com.example.sports.ui // Paquete al que pertenece el archivo

// Importaciones necesarias
import androidx.lifecycle.ViewModel // Base para el ViewModel
import com.example.sports.data.LocalSportsDataProvider // Proveedor de datos locales
import com.example.sports.model.Sport // Modelo de datos Sport
import kotlinx.coroutines.flow.MutableStateFlow // Flujo mutable para estado
import kotlinx.coroutines.flow.StateFlow // Flujo inmutable que se expone
import kotlinx.coroutines.flow.update // Función para actualizar estado de manera segura

/**
 * ViewModel de la aplicación Sports.
 * Controla el estado de la interfaz y las interacciones del usuario.
 */
class SportsViewModel : ViewModel() {

    // Estado interno mutable con lista de deportes y uno seleccionado por defecto
    private val _uiState = MutableStateFlow(
        SportsUiState(
            sportsList = LocalSportsDataProvider.getSportsData(), // Carga lista de deportes
            currentSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                LocalSportsDataProvider.defaultSport // Si no hay datos, usa uno por defecto
            }
        )
    )

    // Estado expuesto como flujo inmutable para que la UI observe cambios
    val uiState: StateFlow<SportsUiState> = _uiState

    /**
     * Actualiza el deporte actualmente seleccionado (para mostrar detalles).
     */
    fun updateCurrentSport(selectedSport: Sport) {
        _uiState.update {
            it.copy(currentSport = selectedSport) // Crea una copia del estado actual con nuevo deporte
        }
    }

    /**
     * Cambia la vista para mostrar la lista de deportes.
     */
    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true) // Indica que se debe mostrar la lista
        }
    }

    /**
     * Cambia la vista para mostrar los detalles del deporte seleccionado.
     */
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false) // Indica que se debe mostrar la vista de detalle
        }
    }
}

/**
 * Clase que modela el estado completo de la interfaz de usuario para SportsApp.
 * 
 * @param sportsList Lista de deportes disponibles
 * @param currentSport Deporte actualmente seleccionado para ver en detalle
 * @param isShowingListPage Booleano que indica si se está mostrando la lista (true) o el detalle (false)
 */
data class SportsUiState(
    val sportsList: List<Sport> = emptyList(), // Lista de deportes
    val currentSport: Sport = LocalSportsDataProvider.defaultSport, // Deporte actual
    val isShowingListPage: Boolean = true // Por defecto, se muestra la lista
)
