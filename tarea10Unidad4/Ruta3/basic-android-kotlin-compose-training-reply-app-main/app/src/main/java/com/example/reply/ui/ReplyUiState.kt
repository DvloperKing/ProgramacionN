/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define la estructura del estado de la interfaz de usuario (UI) para la app Reply.
 * Está licenciado bajo Apache License 2.0.
 */

package com.example.reply.ui

// Importaciones necesarias para el modelo de datos de correos y buzones
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider

/**
 * Clase de datos que representa el estado actual de la interfaz de usuario en la app Reply.
 *
 * @property mailboxes Mapa que asocia cada tipo de buzón (Inbox, Drafts, etc.) con una lista de correos.
 * @property currentMailbox El buzón actualmente seleccionado (por defecto: Inbox).
 * @property currentSelectedEmail El correo actualmente seleccionado (por defecto: uno predeterminado).
 * @property isShowingHomepage Booleano que indica si se está mostrando la pantalla principal (lista de correos).
 */
data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(), // Estado de todos los buzones con sus correos
    val currentMailbox: MailboxType = MailboxType.Inbox,       // Buzón seleccionado por defecto (Inbox)
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail, // Correo seleccionado por defecto
    val isShowingHomepage: Boolean = true                      // Se muestra la pantalla de lista por defecto
) {
    /**
     * Propiedad computada (lazy) que devuelve los correos del buzón actualmente seleccionado.
     * Utiliza 'by lazy' para que se calcule solo una vez y cuando sea necesario.
     *
     * Nota: se usa el operador !! porque se asume que el buzón siempre existirá en el mapa.
     */
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}
