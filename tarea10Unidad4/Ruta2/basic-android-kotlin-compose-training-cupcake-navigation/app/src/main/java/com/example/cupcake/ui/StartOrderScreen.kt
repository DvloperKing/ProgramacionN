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

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Pantalla inicial de la aplicación donde el usuario puede seleccionar la cantidad de cupcakes.
 *
 * @param quantityOptions Lista de opciones en formato (ID recurso string, valor entero).
 * @param onNextButtonClicked Lambda que recibe la cantidad seleccionada y avanza a la siguiente pantalla.
 * @param modifier Modificador opcional para diseño y disposición del componente.
 */
@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección superior con imagen y título
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            // Imagen decorativa del cupcake
            Image(
                painter = painterResource(R.drawable.cupcake),
                contentDescription = null, // Imagen decorativa, sin descripción accesible
                modifier = Modifier.width(300.dp)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            // Texto principal que invita a ordenar cupcakes
            Text(
                text = stringResource(R.string.order_cupcakes),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }

        // Sección inferior con botones para seleccionar cantidad
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            quantityOptions.forEach { item ->
                SelectQuantityButton(
                    labelResourceId = item.first, // ID del texto a mostrar
                    onClick = { onNextButtonClicked(item.second) }, // Envía valor seleccionado
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Composable reutilizable que muestra un botón con texto y ejecuta una acción al hacer clic.
 *
 * @param labelResourceId ID del recurso string que se mostrará como texto del botón.
 * @param onClick Acción a ejecutar cuando se presiona el botón.
 * @param modifier Modificador opcional para adaptar el diseño del botón.
 */
@Composable
fun SelectQuantityButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp) // Asegura un ancho mínimo uniforme
    ) {
        Text(stringResource(labelResourceId))
    }
}

/**
 * Vista previa de la pantalla inicial (solo para entorno de desarrollo).
 */
@Preview
@Composable
fun StartOrderPreview() {
    CupcakeTheme {
        StartOrderScreen(
            quantityOptions = DataSource.quantityOptions,
            onNextButtonClicked = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}
