/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under la Licencia Apache, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en:
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que sea requerido por la ley aplicable o acordado por escrito, el software
 * distribuido bajo la Licencia se distribuye "TAL CUAL", SIN GARANTÍAS NI CONDICIONES
 * DE NINGÚN TIPO, ya sean expresas o implícitas. Consulta la Licencia para conocer
 * el lenguaje específico que rige los permisos y limitaciones bajo la Licencia.
 */

package com.example.reply.data // Paquete donde se encuentra la definición del modelo de datos

import androidx.annotation.DrawableRes // Anotación que indica que un parámetro debe ser un recurso drawable
import androidx.annotation.StringRes   // Anotación que indica que un parámetro debe ser un recurso string

/**
 * Clase de datos que representa una cuenta de usuario.
 *
 * Esta clase encapsula los atributos esenciales de un usuario, incluyendo identificador,
 * nombre, correo electrónico y avatar, y es utilizada en la capa de datos de la aplicación.
 */
data class Account(
    /** Identificador único del usuario **/
    val id: Long,

    /** Nombre del usuario (referenciado mediante recurso de string) **/
    @StringRes val firstName: Int,

    /** Apellido del usuario (referenciado mediante recurso de string) **/
    @StringRes val lastName: Int,

    /** Dirección de correo electrónico del usuario (referenciada mediante recurso de string) **/
    @StringRes val email: Int,

    /** Recurso gráfico que representa el avatar del usuario **/
    @DrawableRes val avatar: Int
)
