// Paquete donde se ubica este archivo. Pertenece al módulo de datos de la app.
package com.example.dessertclicker.data

// Importa la anotación DrawableRes para indicar que se espera un recurso gráfico
import androidx.annotation.DrawableRes

// Importa la lista de postres desde el objeto Datasource
import com.example.dessertclicker.data.Datasource.dessertList

/**
 * Clase de estado UI utilizada por la capa de presentación (Jetpack Compose).
 *
 * Representa el estado actual del juego de postres, incluyendo la información necesaria
 * para actualizar la interfaz gráfica como: postre actual, postres vendidos y ganancias.
 *
 * Esta clase es inmutable, lo que permite un manejo seguro y predecible del estado.
 */
data class DessertUiState(
    // Índice actual del postre en la lista
    val currentDessertIndex: Int = 0,

    // Cantidad total de postres vendidos hasta ahora
    val dessertsSold: Int = 0,

    // Ingreso total generado por las ventas de postres
    val revenue: Int = 0,

    // Precio del postre actual (derivado del índice actual en la lista)
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,

    // ID del recurso gráfico del postre actual (derivado del índice actual en la lista)
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)
