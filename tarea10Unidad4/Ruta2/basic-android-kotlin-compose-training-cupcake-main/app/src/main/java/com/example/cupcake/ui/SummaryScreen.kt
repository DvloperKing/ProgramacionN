/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto de acuerdo con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley aplicable lo requiera o se acuerde por escrito, el software
 * distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sea expresas o implícitas.
 * Consulta la Licencia para conocer el lenguaje específico que rige los permisos y limitaciones.
 */

package com.example.cupcake.ui

// Importaciones necesarias para el diseño visual y funcionalidad
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.components.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Composable que representa la pantalla de resumen del pedido.
 *
 * Se espera un estado [orderUiState] que contiene los datos del pedido.
 * La lambda [onCancelButtonClicked] se activa al presionar "Cancelar".
 * La lambda [onSendButtonClicked] se activa para enviar el resumen final del pedido.
 */
@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources

    // Obtener cadena pluralizada para la cantidad de cupcakes (por ejemplo: "1 cupcake", "3 cupcakes")
    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    // Construye el resumen del pedido en una cadena de texto
    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )

    // Cadena con el asunto del pedido (ej. para envío por correo o mensaje)
    val newOrder = stringResource(R.string.new_cupcake_order)

    // Lista de elementos con clave/valor para mostrar en pantalla (Cantidad, Sabor, Fecha)
    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupcakes),
        Pair(stringResource(R.string.flavor), orderUiState.flavor),
        Pair(stringResource(R.string.pickup_date), orderUiState.date)
    )

    // Estructura principal en columna, distribuye los elementos entre inicio y fin
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Contenedor de detalles del pedido
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            // Mostrar cada campo del pedido en su respectiva línea
            items.forEach { item ->
                Text(item.first.uppercase()) // Etiqueta (ej. "FLAVOR")
                Text(text = item.second, fontWeight = FontWeight.Bold) // Valor (ej. "Chocolate")
                Divider(thickness = dimensionResource(R.dimen.thickness_divider)) // Separador visual
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            // Mostrar el total formateado como precio
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }

        // Botones de acción (Enviar, Cancelar)
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                // Botón para confirmar y enviar el pedido
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSendButtonClicked(newOrder, orderSummary) }
                ) {
                    Text(stringResource(R.string.send))
                }

                // Botón para cancelar el pedido y volver atrás
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}

/**
 * Vista previa de diseño para visualizar cómo luce esta pantalla en el editor.
 */
@Preview
@Composable
fun OrderSummaryPreview() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Test", "Test", "$300.00"),
            onSendButtonClicked = { _, _ -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}
