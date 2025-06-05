/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo la Apache License, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley aplicable lo requiera o se acuerde por escrito, el software
 * distribuido bajo esta Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulta la Licencia para conocer el lenguaje específico que rige los permisos y limitaciones.
 */

package com.example.cupcake.ui.components // Paquete donde se agrupan componentes reutilizables de UI

// Imports necesarios de Jetpack Compose y Material 3
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cupcake.R

/**
 * Composable que muestra el [subtotal] formateado como texto.
 * El texto se obtiene desde un recurso de string con formato (ej. "Subtotal: $12").
 *
 * @param subtotal Valor total parcial a mostrar (en formato String, ej. "$24").
 * @param modifier Modificador opcional para aplicar estilo o posicionamiento externo al componente.
 */
@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    Text(
        // Muestra el texto con formato obtenido desde strings.xml usando el ID R.string.subtotal_price
        text = stringResource(R.string.subtotal_price, subtotal),
        // Aplica el modificador externo recibido como parámetro (por defecto es Modifier)
        modifier = modifier,
        // Usa el estilo tipográfico definido por el tema para títulos pequeños (headlineSmall)
        style = MaterialTheme.typography.headlineSmall
    )
}
