/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo exija la ley aplicable o esté acordado por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulta la Licencia para los términos específicos que rigen los permisos y limitaciones.
 */

package com.example.reply.data // Paquete que contiene el modelo de datos de la app

import androidx.annotation.StringRes // Anotación para validar que los valores sean recursos string

/**
 * Clase de datos que representa un correo electrónico en la aplicación.
 */
data class Email(
    /** Identificador único del correo electrónico **/
    val id: Long,

    /** Cuenta del remitente que envía el correo **/
    val sender: Account,

    /** Lista de cuentas destinatarias del correo (por defecto vacía) **/
    val recipients: List<Account> = emptyList(),

    /** Asunto del correo electrónico, referenciado desde los recursos de strings **/
    @StringRes val subject: Int = -1,

    /** Cuerpo del mensaje del correo, también como recurso string **/
    @StringRes val body: Int = -1,

    /** Tipo de buzón en el que se encuentra el correo (por defecto: Inbox) **/
    var mailbox: MailboxType = MailboxType.Inbox,

    /**
     * Tiempo relativo de creación del correo (por ejemplo: "hace 20 minutos").
     * Actualmente es un recurso de texto fijo (se podría mejorar con lógica de tiempo real).
     */
    var createdAt: Int = -1
)
