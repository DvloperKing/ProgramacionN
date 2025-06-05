/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.reply.ui // Define el paquete al que pertenece el archivo dentro del módulo de UI de la app

import com.example.reply.data.Email // Importa la clase de datos Email, que representa un correo individual
import com.example.reply.data.MailboxType // Importa el enum MailboxType que define los tipos de buzón (Inbox, Sent, etc.)
import com.example.reply.data.local.LocalEmailsDataProvider // Fuente de datos de prueba que contiene correos predeterminados

// Clase de datos que representa el estado completo de la interfaz de usuario de la app Reply
data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(), // Mapa de correos por tipo de buzón (vacío por defecto)
    val currentMailbox: MailboxType = MailboxType.Inbox, // Tipo de buzón actualmente seleccionado (por defecto: Inbox)
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail, // Correo seleccionado actualmente en la vista de detalles
    val isShowingHomepage: Boolean = true // Indica si se está mostrando la pantalla principal (lista de correos)
) {
    // Propiedad derivada que obtiene la lista de correos correspondiente al buzón actualmente seleccionado.
    // Se evalúa una sola vez cuando se accede por primera vez gracias al uso de 'lazy'.
    // El uso de '!!' implica que se asume que la clave existe en el mapa, lo cual debe garantizarse en tiempo de ejecución.
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}
