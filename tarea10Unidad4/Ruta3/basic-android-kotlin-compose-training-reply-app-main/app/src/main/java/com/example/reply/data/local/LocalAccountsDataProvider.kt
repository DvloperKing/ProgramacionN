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

package com.example.reply.data.local // Define la ubicación del archivo dentro del módulo de datos locales

// Importa recursos y modelo de datos
import com.example.reply.R
import com.example.reply.data.Account

/**
 * Objeto singleton que actúa como una fuente estática (inmutable) de datos de cuentas [Account].
 * Incluye una lista de contactos simulados y una cuenta por defecto.
 */
object LocalAccountsDataProvider {

    /**
     * Cuenta por defecto que puede utilizarse como valor inicial o nulo lógico.
     * Utiliza IDs y referencias a strings inválidas (-1), junto con un avatar predeterminado.
     */
    val defaultAccount = Account(
        id = -1,
        firstName = -1,
        lastName = -1,
        email = -1,
        avatar = R.drawable.avatar_1
    )

    /**
     * Lista inmutable que contiene todas las cuentas de contacto asociadas al usuario actual.
     * Los nombres, apellidos y correos están referenciados como recursos para facilitar localización.
     */
    private val allUserContactAccounts = listOf(
        Account(
            id = 4L,
            firstName = R.string.account_4_first_name,
            lastName = R.string.account_4_last_name,
            email = R.string.account_4_email,
            avatar = R.drawable.avatar_1
        ),
        Account(
            id = 5L,
            firstName = R.string.account_5_first_name,
            lastName = R.string.account_5_last_name,
            email = R.string.account_5_email,
            avatar = R.drawable.avatar_3
        ),
        Account(
            id = 6L,
            firstName = R.string.account_6_first_name,
            lastName = R.string.account_6_last_name,
            email = R.string.account_6_email,
            avatar = R.drawable.avatar_5
        ),
        Account(
            id = 7L,
            firstName = R.string.account_7_first_name,
            lastName = R.string.account_7_last_name,
            email = R.string.account_7_email,
            avatar = R.drawable.avatar_0
        ),
        Account(
            id = 8L,
            firstName = R.string.account_8_first_name,
            lastName = R.string.account_8_last_name,
            email = R.string.account_8_email,
            avatar = R.drawable.avatar_7
        ),
        Account(
            id = 9L,
            firstName = R.string.account_9_first_name,
            lastName = R.string.account_9_last_name,
            email = R.string.account_9_email,
            avatar = R.drawable.avatar_express
        ),
        Account(
            id = 10L,
            firstName = R.string.account_10_first_name,
            lastName = R.string.account_10_last_name,
            email = R.string.account_10_email,
            avatar = R.drawable.avatar_2
        ),
        Account(
            id = 11L,
            firstName = R.string.account_11_first_name,
            lastName = R.string.account_11_last_name,
            email = R.string.account_11_email,
            avatar = R.drawable.avatar_8
        ),
        Account(
            id = 12L,
            firstName = R.string.account_12_first_name,
            lastName = R.string.account_12_last_name,
            email = R.string.account_12_email,
            avatar = R.drawable.avatar_6
        ),
        Account(
            id = 13L,
            firstName = R.string.account_13_first_name,
            lastName = R.string.account_13_last_name,
            email = R.string.account_13_email,
            avatar = R.drawable.avatar_4
        )
    )

    /**
     * Devuelve una cuenta de contacto según el ID proporcionado.
     * Si no se encuentra ninguna coincidencia, devuelve el primer contacto de la lista.
     *
     * @param accountId ID de la cuenta que se desea buscar.
     * @return Objeto [Account] correspondiente o el primer contacto por defecto.
     */
    fun getContactAccountById(accountId: Long): Account {
        return allUserContactAccounts.firstOrNull { it.id == accountId }
            ?: allUserContactAccounts.first()
    }
}
