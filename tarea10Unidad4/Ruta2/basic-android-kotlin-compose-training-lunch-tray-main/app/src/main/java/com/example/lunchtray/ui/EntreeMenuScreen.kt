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
import com.example.lunchtray.model.MenuItem.EntreeItem

/**
 * Pantalla para seleccionar una entrada principal del menú (entree).
 *
 * Esta función composable muestra una lista de opciones de tipo [EntreeItem]
 * y reutiliza el componente genérico [BaseMenuScreen] para mostrar las opciones.
 *
 * @param options Lista de entradas disponibles.
 * @param onCancelButtonClicked Acción al presionar "Cancelar".
 * @param onNextButtonClicked Acción al presionar "Siguiente".
 * @param onSelectionChanged Acción que ocurre cuando el usuario selecciona una entrada.
 * @param modifier Modificador opcional para diseño.
 */
@Composable
fun EntreeMenuScreen(
    options: List<EntreeItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (EntreeItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        // Se hace cast de la función para ajustarse a la firma genérica (MenuItem)
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier
    )
}

/**
 * Vista previa de la pantalla de selección de entradas (entrees).
 * Muestra las opciones definidas en [DataSource] con scroll vertical y padding.
 */
@Preview
@Composable
fun EntreeMenuPreview() {
    EntreeMenuScreen(
        options = DataSource.entreeMenuItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
