/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo exija la ley aplicable o esté acordado por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulta la Licencia para los términos específicos que rigen permisos y limitaciones.
 */

package com.example.reply.data // Paquete donde reside la definición de modelos de datos

/**
 * Enumeración que representa los diferentes tipos de bandejas o carpetas de correo electrónico.
 *
 * Se utiliza para categorizar un mensaje dentro de la app (por ejemplo, si está enviado o en spam).
 */
enum class MailboxType {
    /** Bandeja de entrada: correos recibidos por el usuario **/
    Inbox,

    /** Borradores: correos que fueron escritos pero no enviados aún **/
    Drafts,

    /** Enviados: correos que el usuario ya ha enviado **/
    Sent,

    /** Correo no deseado: correos detectados como spam **/
    Spam
}
