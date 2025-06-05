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
package com.example.reply.ui // Declaración del paquete al que pertenece la clase ViewModel

import androidx.lifecycle.ViewModel // Importa la clase base ViewModel de Jetpack para manejar el estado de UI
import com.example.reply.data.Email // Importa la clase de datos que representa un correo electrónico
import com.example.reply.data.MailboxType // Importa el enum que representa tipos de buzones (Inbox, Sent, etc.)
import com.example.reply.data.local.LocalEmailsDataProvider // Proveedor de datos locales simulados (para pruebas)
import kotlinx.coroutines.flow.MutableStateFlow // Flujo mutable para manejar estado reactivo
import kotlinx.coroutines.flow.StateFlow // Interfaz pública de solo lectura del flujo de estado
import kotlinx.coroutines.flow.update // Función para modificar el estado de un MutableStateFlow

// Clase ViewModel encargada de manejar y actualizar el estado de la UI de la app Reply
class ReplyViewModel : ViewModel() {

    // Flujo interno mutable que contiene el estado actual de la interfaz
    private val _uiState = MutableStateFlow(ReplyUiState())

    // Interfaz pública del estado expuesta como StateFlow inmutable para la vista
    val uiState: StateFlow<ReplyUiState> = _uiState

    // Bloque init que se ejecuta al crear la instancia del ViewModel
    init {
        initializeUIState() // Inicializa el estado con los correos agrupados por tipo de buzón
    }

    // Función que inicializa el estado agrupando los correos por buzón (Inbox, Sent, etc.)
    private fun initializeUIState() {
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox } // Agrupa correos por su tipo de buzón
        _uiState.value =
            ReplyUiState(
                mailboxes = mailboxes,
                currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail // Selecciona el primer correo del inbox o uno por defecto
            )
    }

    // Función que actualiza el estado para mostrar los detalles de un correo específico
    fun updateDetailsScreenStates(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail = email, // Cambia el correo actualmente seleccionado
                isShowingHomepage = false // Oculta la pantalla de lista de correos
            )
        }
    }

    // Función que reinicia el estado a la pantalla principal con el primer correo del buzón actual
    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail, // Selecciona el primer correo disponible
                isShowingHomepage = true // Muestra nuevamente la lista principal
            )
        }
    }

    // Función que actualiza el buzón actualmente activo (Inbox, Drafts, etc.)
    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update {
            it.copy(
                currentMailbox = mailboxType // Cambia el buzón visible
            )
        }
    }
}
