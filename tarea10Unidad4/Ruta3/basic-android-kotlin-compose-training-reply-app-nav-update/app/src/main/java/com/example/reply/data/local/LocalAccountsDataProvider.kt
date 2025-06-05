/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define una fuente de datos local (mock) para las cuentas de usuario y contactos.
 * Está diseñado para simular la obtención de datos en ausencia de una base de datos o backend.
 */

package com.example.reply.data.local

// Importa recursos visuales (avatars) y referencias a strings localizados
import com.example.reply.R
import com.example.reply.data.Account

/**
 * Objeto singleton que actúa como fuente estática de datos de tipo [Account].
 * Contiene la cuenta del usuario actual y la lista de contactos disponibles.
 */
object LocalAccountsDataProvider {

    /**
     * Cuenta vacía por defecto, usada como fallback.
     * Sus campos son valores inválidos (-1) o avatar predeterminado.
     */
    val defaultAccount = Account(-1, -1, -1, -1, R.drawable.avatar_1)

    /**
     * Cuenta del usuario actual (el que está usando la app).
     * Utiliza IDs de recursos para acceder a nombre, apellido y correo electrónico.
     */
    val userAccount = Account(
        id = 1,
        firstName = R.string.account_1_first_name,
        lastName = R.string.account_1_last_name,
        email = R.string.account_1_email,
        avatar = R.drawable.avatar_1
    )

    /**
     * Lista de contactos simulados del usuario actual.
     * Cada cuenta tiene un ID único, avatar y referencias a strings localizados.
     */
    private val allUserContactAccounts = listOf(
        Account(4L, R.string.account_4_first_name, R.string.account_4_last_name, R.string.account_4_email, R.drawable.avatar_1),
        Account(5L, R.string.account_5_first_name, R.string.account_5_last_name, R.string.account_5_email, R.drawable.avatar_3),
        Account(6L, R.string.account_6_first_name, R.string.account_6_last_name, R.string.account_6_email, R.drawable.avatar_5),
        Account(7L, R.string.account_7_first_name, R.string.account_7_last_name, R.string.account_7_email, R.drawable.avatar_0),
        Account(8L, R.string.account_8_first_name, R.string.account_8_last_name, R.string.account_8_email, R.drawable.avatar_7),
        Account(9L, R.string.account_9_first_name, R.string.account_9_last_name, R.string.account_9_email, R.drawable.avatar_express),
        Account(10L, R.string.account_10_first_name, R.string.account_10_last_name, R.string.account_10_email, R.drawable.avatar_2),
        Account(11L, R.string.account_11_first_name, R.string.account_11_last_name, R.string.account_11_email, R.drawable.avatar_8),
        Account(12L, R.string.account_12_first_name, R.string.account_12_last_name, R.string.account_12_email, R.drawable.avatar_6),
        Account(13L, R.string.account_13_first_name, R.string.account_13_last_name, R.string.account_13_email, R.drawable.avatar_4)
    )

    /**
     * Retorna el contacto correspondiente al ID dado.
     * Si no se encuentra, retorna el primer contacto de la lista como valor por defecto.
     *
     * @param accountId ID de la cuenta a buscar
     * @return Cuenta encontrada o primera cuenta disponible si no existe coincidencia
     */
    fun getContactAccountById(accountId: Long): Account {
        return allUserContactAccounts.firstOrNull { it.id == accountId }
            ?: allUserContactAccounts.first()
    }
}
