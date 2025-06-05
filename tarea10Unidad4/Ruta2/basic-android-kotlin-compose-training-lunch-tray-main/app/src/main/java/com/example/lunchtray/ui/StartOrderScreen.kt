/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lunchtray.ui // Paquete donde se encuentra el archivo, parte de la capa de UI (interfaz de usuario)

import androidx.compose.foundation.layout.Arrangement // Para definir la disposición vertical u horizontal de elementos
import androidx.compose.foundation.layout.Column // Contenedor de layout que organiza elementos en columna
import androidx.compose.foundation.layout.fillMaxSize // Modificador para que el elemento ocupe todo el tamaño disponible
import androidx.compose.foundation.layout.padding // Modificador para agregar espacio alrededor de un componente
import androidx.compose.foundation.layout.widthIn // Modificador que define un ancho mínimo/máximo
import androidx.compose.material3.Button // Componente de botón de Material 3
import androidx.compose.material3.Text // Componente de texto de Material 3
import androidx.compose.runtime.Composable // Anotación que indica que una función es una UI composable
import androidx.compose.ui.Alignment // Define alineación de elementos en layouts
import androidx.compose.ui.Modifier // Objeto que permite aplicar decoraciones o comportamientos a componentes
import androidx.compose.ui.res.dimensionResource // Permite acceder a recursos de dimensiones definidas en XML
import androidx.compose.ui.res.stringResource // Permite acceder a strings definidos en XML (localización)
import androidx.compose.ui.tooling.preview.Preview // Anotación que permite previsualizar la composable en el editor
import androidx.compose.ui.unit.dp // Unidad de medida para dimensiones (density-independent pixels)
import com.example.lunchtray.R // Referencia al archivo R que contiene recursos como strings y dimensiones

/**
 * Pantalla de inicio donde el usuario comienza el pedido.
 *
 * @param onStartOrderButtonClicked Función lambda que se ejecuta al presionar el botón "Start Order".
 * @param modifier Parámetro opcional para aplicar modificadores externos (como padding o tamaño).
 */
@Composable
fun StartOrderScreen(
    onStartOrderButtonClicked: () -> Unit, // Callback que se invoca cuando se presiona el botón
    modifier: Modifier = Modifier // Modificador por defecto que permite aplicar estilos y tamaños
) {
    Column(
        modifier = modifier, // Aplica el modificador recibido (puede incluir padding, tamaño, etc.)
        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos hijos horizontalmente
        verticalArrangement = Arrangement.Center // Centra los elementos verticalmente en la pantalla
    ) {
        Button(
            onClick = onStartOrderButtonClicked, // Llama a la función pasada cuando se hace clic en el botón
            Modifier.widthIn(min = 250.dp) // El ancho mínimo del botón es 250dp, útil en pantallas grandes
        ) {
            Text(stringResource(R.string.start_order)) // Texto del botón, extraído de los recursos (permitiendo localización)
        }
    }
}

/**
 * Previsualización de la pantalla StartOrderScreen en el editor de Android Studio.
 */
@Preview
@Composable
fun StartOrderPreview(){
    StartOrderScreen(
        onStartOrderButtonClicked = {}, // No se realiza ninguna acción en la previsualización
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)) // Aplica un padding medio definido en resources
            .fillMaxSize() // Hace que la pantalla ocupe todo el tamaño del contenedor
    )
}
