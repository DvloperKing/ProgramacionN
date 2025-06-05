/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define el modelo de datos para representar un correo electrónico.
 * Está licenciado bajo la Licencia Apache 2.0.
 */

package com.example.reply.data

// Anotación para indicar que ciertas propiedades son recursos de tipo string
import androidx.annotation.StringRes

/**
 * Clase de datos que representa un correo electrónico.
 *
 * Esta clase es utilizada para poblar la UI con la información relevante de cada mensaje:
 * remitente, destinatarios, asunto, contenido, tipo de buzón y fecha.
 */
data class Email(
    /** ID único del correo (identificador de la base de datos o mock) **/
    val id: Long,

    /** Cuenta del remitente del correo (quién lo envió) **/
    val sender: Account,

    /** Lista de destinatarios del correo (quiénes lo reciben). Puede estar vacía. **/
    val recipients: List<Account> = emptyList(),

    /** Título o asunto del correo, representado como referencia a un recurso string **/
    @StringRes val subject: Int = -1,

    /** Contenido o cuerpo del correo, también como recurso string **/
    @StringRes val body: Int = -1,

    /** Tipo de buzón al que pertenece el correo (Inbox, Sent, Drafts, Spam) **/
    var mailbox: MailboxType = MailboxType.Inbox,

    /**
     * Fecha o duración relativa de creación del correo (ej. "hace 20 minutos").
     * En este proyecto está representado por una referencia a un string predefinido.
     */
    @StringRes var createdAt: Int = -1
)
