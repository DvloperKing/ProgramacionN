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
 * Pantalla que muestra un resumen del pedido realizado por el usuario.
 *
 * @param orderUiState Estado actual del pedido con datos como cantidad, sabor y fecha.
 * @param onCancelButtonClicked Lambda que se ejecuta al presionar "Cancelar".
 * @param onSendButtonClicked Lambda que se ejecuta al presionar "Enviar", con asunto y resumen del pedido.
 * @param modifier Modificador opcional para el diseño del contenedor.
 */
@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Obtiene los recursos de contexto para strings y pluralizaciones
    val resources = LocalContext.current.resources

    // Devuelve un string pluralizado según la cantidad de cupcakes
    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    // Crea un resumen completo del pedido (para enviar por correo u otro medio)
    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )

    // Asunto para el mensaje (correo)
    val newOrder = stringResource(R.string.new_cupcake_order)

    // Lista con elementos de resumen (etiqueta y valor)
    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupcakes),
        Pair(stringResource(R.string.flavor), orderUiState.flavor),
        Pair(stringResource(R.string.pickup_date), orderUiState.date)
    )

    // Estructura principal de la pantalla
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección de resumen de pedido
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items.forEach { item ->
                Text(item.first.uppercase()) // Título en mayúsculas
                Text(text = item.second, fontWeight = FontWeight.Bold) // Valor en negritas
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            // Muestra el subtotal con estilo formateado
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }

        // Sección de botones de acción (Enviar y Cancelar)
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSendButtonClicked(newOrder, orderSummary) }
                ) {
                    Text(stringResource(R.string.send))
                }
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
 * Vista previa del resumen del pedido (modo diseño)
 */
@Preview
@Composable
fun OrderSummaryPreview() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Test", "Test", "$300.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}
