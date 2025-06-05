/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo requiera o se acuerde por escrito, el software
 * distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulta la Licencia para conocer el lenguaje específico que rige permisos y limitaciones.
 */

// Paquete donde se ubica este componente UI
package com.example.cupcake.ui.components

// Importa el tema visual de Material 3, incluyendo tipografías y estilos
import androidx.compose.material3.MaterialTheme

// Importa el componente de texto para mostrar contenido textual en pantalla
import androidx.compose.material3.Text

// Indica que esta función es una función @Composable que se puede usar en la UI de Jetpack Compose
import androidx.compose.runtime.Composable

// Permite aplicar modificaciones (padding, alineación, etc.) al componente
import androidx.compose.ui.Modifier

// Permite obtener cadenas desde el archivo de recursos (strings.xml)
import androidx.compose.ui.res.stringResource

// Acceso a los recursos del proyecto, como R.string.subtotal_price
import com.example.cupcake.R

/**
 * Composable que muestra el [subtotal] formateado en pantalla.
 * Este subtotal se mostrará usando los estilos del tema y en el formato definido
 * por la cadena en strings.xml, por ejemplo: "Subtotal: $10.00"
 */
@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    // Muestra un texto formateado con estilo de encabezado pequeño (headlineSmall)
    Text(
        // Recupera la cadena desde los recursos (strings.xml) y le inserta el valor de subtotal
        text = stringResource(R.string.subtotal_price, subtotal),

        // Aplica cualquier modificador externo (por defecto, sin modificaciones)
        modifier = modifier,

        // Usa el estilo tipográfico definido como headlineSmall en el tema
        style = MaterialTheme.typography.headlineSmall
    )
}
