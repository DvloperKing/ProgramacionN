package com.example.dessertclicker.ui

// Importa ViewModel para manejar lógica desacoplada de la UI
import androidx.lifecycle.ViewModel
// Importa el estado de UI personalizado
import com.example.dessertclicker.data.DessertUiState
// Importa la lista de postres desde el Datasource
import com.example.dessertclicker.data.Datasource.dessertList
// Importa APIs de Flow para estado reactivo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel responsable de mantener y actualizar el estado de la UI
 * en la app Dessert Clicker. Sigue el patrón MVVM usando StateFlow
 * para exponer datos inmutables a la capa de presentación.
 */
class DessertViewModel : ViewModel() {

    // Estado mutable interno privado (sólo modificable dentro del ViewModel)
    private val _dessertUiState = MutableStateFlow(DessertUiState())

    // Estado público e inmutable expuesto a la UI (ej. Jetpack Compose)
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()

    /**
     * Función que se llama cada vez que el usuario hace clic en el postre.
     * Incrementa el número de postres vendidos y actualiza el postre mostrado
     * según la cantidad vendida.
     */
    fun onDessertClicked() {
        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)

            // Crea una nueva copia del estado con los valores actualizados
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    /**
     * Determina el índice del postre que debe mostrarse basado en la cantidad
     * de postres vendidos. La lista está ordenada por `startProductionAmount`.
     *
     * @param dessertsSold cantidad total de postres vendidos
     * @return índice del postre a mostrar en la lista `dessertList`
     */
    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                // Se detiene tan pronto como el postre siguiente requiere más ventas que las actuales
                break
            }
        }
        return dessertIndex
    }
}
