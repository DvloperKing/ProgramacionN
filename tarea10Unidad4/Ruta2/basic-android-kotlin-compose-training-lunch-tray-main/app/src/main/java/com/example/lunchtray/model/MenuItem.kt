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

package com.example.lunchtray.model

import java.text.NumberFormat

/**
 * Clase sellada que representa un ítem del menú general (entrada, guarnición o acompañamiento).
 *
 * Esta clase se utiliza como modelo base para representar cada tipo de ítem del menú en la app.
 * Contiene atributos comunes: nombre, descripción y precio.
 */
sealed class MenuItem(
    open val name: String,         // Nombre del ítem
    open val description: String,  // Descripción del ítem
    open val price: Double         // Precio del ítem (sin formato)
) {

    /**
     * Subclase para ítems de tipo entrada ("entree").
     */
    data class EntreeItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Subclase para ítems de tipo guarnición ("side dish").
     */
    data class SideDishItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Subclase para ítems de tipo acompañamiento ("accompaniment").
     */
    data class AccompanimentItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    /**
     * Función que devuelve el precio con formato de moneda local.
     * Utiliza la clase `NumberFormat` para aplicar el formato adecuado.
     *
     * @return Precio formateado como string (ej. "$2.50")
     */
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}
