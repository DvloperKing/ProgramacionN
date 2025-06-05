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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.lunchtray.R
import com.example.lunchtray.model.MenuItem

/**
 * Pantalla base reutilizable que muestra una lista de ítems del menú y botones de navegación.
 *
 * @param options Lista de objetos [MenuItem] a mostrar como opciones.
 * @param modifier Modificador para diseño y disposición.
 * @param onCancelButtonClicked Lambda que se ejecuta al presionar el botón "Cancelar".
 * @param onNextButtonClicked Lambda que se ejecuta al presionar el botón "Siguiente".
 * @param onSelectionChanged Lambda que se ejecuta cuando el usuario selecciona un ítem.
 */
@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    modifier: Modifier = Modifier,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (MenuItem) -> Unit,
) {
    // Guarda el nombre del ítem seleccionado (se usa para habilitar el botón "Next")
    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        // Recorre y muestra cada ítem como una fila con botón de radio
        options.forEach { item ->
            val onClick = {
                selectedItemName = item.name
                onSelectionChanged(item)
            }

            MenuItemRow(
                item = item,
                selectedItemName = selectedItemName,
                onClick = onClick,
                modifier = Modifier
                    .selectable(
                        selected = selectedItemName == item.name,
                        onClick = onClick
                    )
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                    )
            )
        }

        // Muestra el grupo de botones "Cancelar" y "Siguiente"
        MenuScreenButtonGroup(
            selectedItemName = selectedItemName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = {
                // El botón solo está habilitado si hay una selección
                onNextButtonClicked()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

/**
 * Composable que representa una fila con botón de selección y detalles del ítem del menú.
 *
 * @param item Elemento del menú que se está mostrando.
 * @param selectedItemName Nombre del ítem actualmente seleccionado.
 * @param onClick Acción a ejecutar al seleccionar el ítem.
 * @param modifier Modificador para diseño y disposición.
 */
@Composable
fun MenuItemRow(
    item: MenuItem,
    selectedItemName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedItemName == item.name,
            onClick = onClick
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = item.getFormattedPrice(),
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

/**
 * Grupo de botones que permite al usuario cancelar o continuar después de hacer una selección.
 *
 * @param selectedItemName Nombre del ítem seleccionado (determina si "Siguiente" está habilitado).
 * @param onCancelButtonClicked Acción al presionar "Cancelar".
 * @param onNextButtonClicked Acción al presionar "Siguiente".
 * @param modifier Modificador para disposición.
 */
@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        // Botón de cancelar
        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = onCancelButtonClicked
        ) {
            Text(stringResource(R.string.cancel).uppercase())
        }

        // Botón de continuar, solo activo si hay una selección
        Button(
            modifier = Modifier.weight(1f),
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next).uppercase())
        }
    }
}
