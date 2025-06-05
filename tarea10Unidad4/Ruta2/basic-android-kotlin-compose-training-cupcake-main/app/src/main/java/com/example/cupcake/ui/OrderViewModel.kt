/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito, el software
 * distribuido bajo esta Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 */

package com.example.cupcake.ui // Paquete correspondiente a la capa de presentación (UI y lógica de estado)

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

/** Precio base por cada cupcake */
private const val PRICE_PER_CUPCAKE = 2.00

/** Costo adicional por recoger el pedido el mismo día */
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

/**
 * [OrderViewModel] contiene y gestiona el estado del pedido de cupcakes.
 * Incluye cantidad, sabor, fecha de recogida y precio total. Además, proporciona funciones
 * para modificar y recalcular el estado del pedido.
 */
class OrderViewModel : ViewModel() {

    /**
     * Estado interno mutable del pedido, basado en un flujo de estado (StateFlow).
     * Se inicializa con una lista de fechas generada dinámicamente.
     */
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))

    /**
     * Estado externo inmutable expuesto a la UI para observar cambios de forma reactiva.
     */
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Establece la cantidad de cupcakes deseada y recalcula el precio total.
     *
     * @param numberCupcakes cantidad seleccionada por el usuario
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
     * Establece el sabor del pedido.
     * Solo se puede seleccionar un sabor por pedido.
     *
     * @param desiredFlavor texto del sabor elegido (ej. "Chocolate")
     */
    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = desiredFlavor)
        }
    }

    /**
     * Establece la fecha de recogida del pedido y actualiza el precio si aplica recargo.
     *
     * @param pickupDate fecha seleccionada en formato "E MMM d"
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
     * Reinicia completamente el estado del pedido a sus valores por defecto.
     */
    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    /**
     * Calcula el precio total del pedido según la cantidad y si la fecha seleccionada
     * corresponde al mismo día (lo que añade un recargo).
     *
     * @param quantity cantidad de cupcakes (por defecto toma el del estado actual)
     * @param pickupDate fecha seleccionada (por defecto toma la del estado actual)
     * @return precio total en formato de moneda local
     */
    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
        // Si la fecha seleccionada es la de hoy, se aplica un cargo extra
        if (pickupOptions()[0] == pickupDate) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }

    /**
     * Genera una lista de 4 fechas de recogida: hoy y los siguientes 3 días.
     * Se usa en la UI como opciones disponibles para el usuario.
     *
     * @return lista de fechas con formato "E MMM d", según la configuración local
     */
    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // Agrega la fecha de hoy y las tres siguientes
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}
