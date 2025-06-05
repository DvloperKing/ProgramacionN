/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define una enumeración para clasificar los correos electrónicos por tipo de buzón.
 * Está licenciado bajo Apache License 2.0.
 */

package com.example.reply.data

/**
 * Clase enumerada que representa los distintos tipos de buzones disponibles en la aplicación.
 * Esta clasificación es útil para filtrar, agrupar o mostrar correos según su categoría.
 */
enum class MailboxType {
    /** Buzón de entrada: contiene correos recibidos */
    Inbox,

    /** Borradores: contiene correos guardados temporalmente pero no enviados */
    Drafts,

    /** Enviados: contiene correos que el usuario ya ha enviado */
    Sent,

    /** Correo no deseado o spam: mensajes potencialmente irrelevantes o sospechosos */
    Spam
}
