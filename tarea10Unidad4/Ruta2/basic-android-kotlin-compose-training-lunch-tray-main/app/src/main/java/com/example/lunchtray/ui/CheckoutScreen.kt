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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.OrderUiState

/**
 * Pantalla de resumen final del pedido antes de confirmar.
 *
 * @param orderUiState Estado actual del pedido con ítems seleccionados y precios.
 * @param onNextButtonClicked Acción que se ejecuta al presionar "Submit".
 * @param onCancelButtonClicked Acción que se ejecuta al presionar "Cancel".
 * @param modifier Modificador opcional para diseño.
 */
@Composable
fun CheckoutScreen(
    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        // Título de la pantalla
        Text(
            text = stringResource(R.string.order_summary),
            fontWeight = FontWeight.Bold
        )

        // Muestra resumen de cada ítem seleccionado
        ItemSummary(item = orderUiState.entree, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.sideDish, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.accompaniment, modifier = Modifier.fillMaxWidth())

        // Línea divisoria
        Divider(
            thickness = dimensionResource(R.dimen.thickness_divider),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )

        // Subtotal, impuesto y total
        OrderSubCost(
            resourceId = R.string.subtotal,
            price = orderUiState.itemTotalPrice.formatPrice(),
            Modifier.align(Alignment.End)
        )
        OrderSubCost(
            resourceId = R.string.tax,
            price = orderUiState.orderTax.formatPrice(),
            Modifier.align(Alignment.End)
        )
        Text(
            text = stringResource(R.string.total, orderUiState.orderTotalPrice.formatPrice()),
            modifier = Modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold
        )

        // Botones de acción: Cancelar y Enviar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel).uppercase())
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.submit).uppercase())
            }
        }
    }
}

/**
 * Muestra una fila con el nombre y precio de un ítem del menú.
 *
 * @param item Elemento del menú (puede ser null).
 * @param modifier Modificador opcional.
 */
@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(item?.name ?: "")
        Text(item?.getFormattedPrice() ?: "")
    }
}

/**
 * Componente reutilizable para mostrar subtotal o impuesto.
 *
 * @param resourceId ID del recurso de texto (por ejemplo, "Subtotal", "Tax").
 * @param price Precio formateado como string.
 * @param modifier Modificador opcional.
 */
@Composable
fun OrderSubCost(
    @StringRes resourceId: Int,
    price: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(resourceId, price),
        modifier = modifier
    )
}

/**
 * Vista previa de la pantalla de checkout.
 */
@Preview
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(
        orderUiState = OrderUiState(
            entree = DataSource.entreeMenuItems[0],
            sideDish = DataSource.sideDishMenuItems[0],
            accompaniment = DataSource.accompanimentMenuItems[0],
            itemTotalPrice = 15.00,
            orderTax = 1.00,
            orderTotalPrice = 16.00
        ),
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
