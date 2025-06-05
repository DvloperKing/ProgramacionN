/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo exija o se acuerde por escrito, este archivo
 * se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/** Precio unitario por cada cupcake */
private const val PRICE_PER_CUPCAKE = 2.00

/** Cargo adicional por seleccionar recolección el mismo día */
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

/**
 * ViewModel que representa el estado de una orden de cupcakes.
 *
 * Esta clase mantiene y administra los datos relacionados con una orden actual: 
 * cantidad, sabor, fecha de recogida y precio.
 */
class OrderViewModel : ViewModel() {

    /**
     * Flujo mutable del estado actual de la orden.
     * El estado inicial incluye las opciones de fechas disponibles para recoger.
     */
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))

    /**
     * Flujo inmutable expuesto a la interfaz de usuario para observar los cambios del estado.
     */
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Establece la cantidad de cupcakes y actualiza el precio total.
     *
     * @param numberCupcakes Cantidad de cupcakes seleccionados por el usuario.
     */
    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcakes,
                price = calculatePrice(quantity = numberCupcakes)
            )
        }
    }

    /**
     * Establece el sabor seleccionado para la orden.
     *
     * @param desiredFlavor Sabor elegido por el usuario.
     */
    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = desiredFlavor)
        }
    }

    /**
     * Establece la fecha de recogida y actualiza el precio si es necesario.
     *
     * @param pickupDate Fecha seleccionada para recoger la orden.
     */
    fun setDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    /**
     * Reinicia todos los datos de la orden al estado inicial.
     */
    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    /**
     * Calcula el precio total en función de la cantidad y la fecha seleccionada.
     * Se aplica un cargo adicional si la recogida es el mismo día.
     *
     * @param quantity Cantidad de cupcakes. Se toma del estado actual si no se pasa.
     * @param pickupDate Fecha de recogida. Se toma del estado actual si no se pasa.
     * @return Precio total formateado como moneda.
     */
    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
        // Si la fecha seleccionada es la primera opción (hoy), se suma el recargo
        if (pickupOptions()[0] == pickupDate) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        // Devuelve el precio formateado como moneda local
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }

    /**
     * Genera una lista de fechas disponibles para la recogida.
     * Comienza desde la fecha actual y añade los siguientes 3 días.
     *
     * @return Lista de fechas formateadas como strings.
     */
    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        // Agrega la fecha de hoy y las siguientes 3 fechas
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}
