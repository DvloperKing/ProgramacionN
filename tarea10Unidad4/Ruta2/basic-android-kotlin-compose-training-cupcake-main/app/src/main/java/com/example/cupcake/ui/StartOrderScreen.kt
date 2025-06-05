/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto cumpliendo la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito, el software
 * distribuido bajo esta Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 */

package com.example.cupcake.ui

// Importaciones necesarias para el diseño visual, interactividad y recursos
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
 * Pantalla inicial que permite al usuario seleccionar la cantidad de cupcakes deseada.
 * Al hacer clic en una opción, se ejecuta el callback [onNextButtonClicked] con la cantidad seleccionada.
 *
 * @param quantityOptions Lista de pares que contienen el recurso de texto y el valor entero.
 * @param onNextButtonClicked Función que se ejecuta cuando el usuario selecciona una cantidad.
 * @param modifier Modificador visual opcional para adaptar el diseño.
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
        // Parte superior: imagen, título e introducción
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium))) // Espaciado superior
            Image(
                painter = painterResource(R.drawable.cupcake),
                contentDescription = null, // Imagen decorativa, sin descripción necesaria
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(R.string.order_cupcakes),
                style = MaterialTheme.typography.headlineSmall // Texto estilizado como título
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }

        // Parte inferior: botones de selección de cantidad
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            quantityOptions.forEach { item ->
                SelectQuantityButton(
                    labelResourceId = item.first, // Texto del botón (por ID de string)
                    onClick = { onNextButtonClicked(item.second) }, // Acción al hacer clic
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

/**
 * Botón reutilizable que muestra un texto [labelResourceId] y ejecuta una acción [onClick].
 *
 * @param labelResourceId Recurso de texto (ej. R.string.one_cupcake)
 * @param onClick Acción al hacer clic.
 * @param modifier Modificador para controlar el ancho mínimo.
 */
@Composable
fun SelectQuantityButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(labelResourceId))
    }
}

/**
 * Vista previa en Android Studio para comprobar cómo se verá la pantalla inicial.
 */
@Preview
@Composable
fun StartOrderPreview() {
    CupcakeTheme {
        StartOrderScreen(
            quantityOptions = DataSource.quantityOptions, // ["1 cupcake", "6 cupcakes", "12 cupcakes"]
            onNextButtonClicked = {}, // Callback vacío para la vista previa
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}
