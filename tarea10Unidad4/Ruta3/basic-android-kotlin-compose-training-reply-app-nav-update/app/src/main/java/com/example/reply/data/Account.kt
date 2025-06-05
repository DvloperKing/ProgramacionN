/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define el modelo de datos para representar una cuenta de usuario.
 * Está licenciado bajo la Licencia Apache 2.0.
 */

package com.example.reply.data

// Anotaciones para indicar que los valores son referencias a recursos (strings e imágenes)
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Clase de datos que representa una cuenta de usuario o contacto en la aplicación.
 * Es utilizada para mostrar información como el nombre, correo y avatar del remitente o destinatario.
 *
 * @property id Identificador único de la cuenta (tipo Long).
 * @property firstName Referencia al recurso string del nombre del usuario.
 * @property lastName Referencia al recurso string del apellido del usuario.
 * @property email Referencia al recurso string de la dirección de correo electrónico.
 * @property avatar Referencia al recurso drawable del avatar del usuario.
 */
data class Account(
    /** ID único del usuario **/
    val id: Long,

    /** Nombre del usuario (recurso string) **/
    @StringRes val firstName: Int,

    /** Apellido del usuario (recurso string) **/
    @StringRes val lastName: Int,

    /** Correo electrónico del usuario (recurso string) **/
    @StringRes val email: Int,

    /** Recurso de imagen para el avatar del usuario (drawable) **/
    @DrawableRes val avatar: Int
)
