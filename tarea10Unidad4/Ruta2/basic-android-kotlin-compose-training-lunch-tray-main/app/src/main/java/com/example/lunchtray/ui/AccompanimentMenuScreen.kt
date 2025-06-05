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

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem

/**
 * Pantalla de selección de acompañamiento para el pedido.
 *
 * @param options Lista de objetos tipo [AccompanimentItem] que representan los acompañamientos disponibles.
 * @param onCancelButtonClicked Lambda que se ejecuta al hacer clic en "Cancelar".
 * @param onNextButtonClicked Lambda que se ejecuta al hacer clic en "Siguiente".
 * @param onSelectionChanged Lambda que se ejecuta cuando el usuario selecciona una opción.
 * @param modifier Modificador para ajustar el diseño y comportamiento visual del componente.
 */
@Composable
fun AccompanimentMenuScreen(
    options: List<AccompanimentItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (AccompanimentItem) -> Unit,
    modifier: Modifier = Modifier
) {
    // Reutiliza el composable BaseMenuScreen para mostrar acompañamientos
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        // Realiza un cast para que el tipo genérico (MenuItem) funcione con AccompanimentItem
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier
    )
}

/**
 * Vista previa en tiempo de diseño de la pantalla de acompañamientos.
 * Utiliza datos de prueba desde DataSource.
 */
@Preview
@Composable
fun AccompanimentMenuPreview() {
    AccompanimentMenuScreen(
        options = DataSource.accompanimentMenuItems,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
