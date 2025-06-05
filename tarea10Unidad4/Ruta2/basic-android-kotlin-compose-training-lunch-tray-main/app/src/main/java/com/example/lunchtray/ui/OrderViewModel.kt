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

package com.example.lunchtray.ui

import androidx.lifecycle.ViewModel
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem
import com.example.lunchtray.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

/**
 * ViewModel encargado de manejar el estado de la orden de comida.
 * Administra la selección de entradas, acompañamientos y platos secundarios,
 * así como los cálculos de subtotal, impuestos y total.
 */
class OrderViewModel : ViewModel() {

    // Tasa de impuesto usada en el cálculo del total (8%)
    private val taxRate = 0.08

    // Estado interno mutable de la UI
    private val _uiState = MutableStateFlow(OrderUiState())

    // Estado expuesto de solo lectura
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Actualiza el estado cuando el usuario selecciona una entrada (entree).
     */
    fun updateEntree(entree: EntreeItem) {
        val previousEntree = _uiState.value.entree
        updateItem(entree, previousEntree)
    }

    /**
     * Actualiza el estado cuando el usuario selecciona un plato secundario (side dish).
     */
    fun updateSideDish(sideDish: SideDishItem) {
        val previousSideDish = _uiState.value.sideDish
        updateItem(sideDish, previousSideDish)
    }

    /**
     * Actualiza el estado cuando el usuario selecciona un acompañamiento (accompaniment).
     */
    fun updateAccompaniment(accompaniment: AccompanimentItem) {
        val previousAccompaniment = _uiState.value.accompaniment
        updateItem(accompaniment, previousAccompaniment)
    }

    /**
     * Restablece todos los valores del pedido a su estado inicial.
     */
    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    /**
     * Función genérica para actualizar cualquier categoría del pedido.
     * Resta el precio del ítem anterior (si existe), suma el nuevo precio
     * y recalcula subtotal, impuestos y total.
     */
    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState ->
            val previousItemPrice = previousItem?.price ?: 0.0
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + newItem.price
            val tax = itemTotalPrice * taxRate
            currentState.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                entree = if (newItem is EntreeItem) newItem else currentState.entree,
                sideDish = if (newItem is SideDishItem) newItem else currentState.sideDish,
                accompaniment = if (newItem is AccompanimentItem) newItem else currentState.accompaniment
            )
        }
    }
}

/**
 * Función de extensión para formatear un número double como precio en la moneda local.
 */
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}
