/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define una fuente de datos local (mock) de objetos Email.
 * Los correos están organizados por tipo de buzón y se usan para poblar la UI de prueba.
 */

package com.example.reply.data.local

// Importación de recursos gráficos y modelos de datos
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.MailboxType

/**
 * Objeto singleton que contiene una lista estática de correos electrónicos [Email].
 */
object LocalEmailsDataProvider {

    /**
     * Lista estática de correos electrónicos simulados.
     * Cada correo tiene un remitente, destinatarios, asunto, cuerpo, fecha y buzón.
     * Los strings se referencian mediante recursos para permitir localización.
     */
    val allEmails = listOf(
        Email(
            id = 0L,
            sender = LocalAccountsDataProvider.getContactAccountById(9L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_0_subject,
            body = R.string.email_0_body,
            createdAt = R.string.email_0_time,
        ),
        Email(
            id = 1L,
            sender = LocalAccountsDataProvider.getContactAccountById(6L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_1_subject,
            body = R.string.email_1_body,
            createdAt = R.string.email_1_time,
        ),
        Email(
            id = 2L,
            sender = LocalAccountsDataProvider.getContactAccountById(5L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_2_subject,
            body = R.string.email_2_body,
            createdAt = R.string.email_2_time,
        ),
        Email(
            id = 3L,
            sender = LocalAccountsDataProvider.getContactAccountById(8L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_3_subject,
            body = R.string.email_3_body,
            createdAt = R.string.email_3_time,
            mailbox = MailboxType.Sent // Este correo está en el buzón de enviados
        ),
        Email(
            id = 4L,
            sender = LocalAccountsDataProvider.getContactAccountById(11L),
            subject = R.string.email_4_subject,
            body = R.string.email_4_body,
            createdAt = R.string.email_4_time,
        ),
        Email(
            id = 5L,
            sender = LocalAccountsDataProvider.getContactAccountById(13L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_5_subject,
            body = R.string.email_5_body,
            createdAt = R.string.email_5_time,
        ),
        Email(
            id = 6L,
            sender = LocalAccountsDataProvider.getContactAccountById(10L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_6_subject,
            body = R.string.email_6_body,
            createdAt = R.string.email_6_time,
            mailbox = MailboxType.Sent
        ),
        Email(
            id = 7L,
            sender = LocalAccountsDataProvider.getContactAccountById(9L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_7_subject,
            body = R.string.email_7_body,
            createdAt = R.string.email_7_time,
        ),
        Email(
            id = 8L,
            sender = LocalAccountsDataProvider.getContactAccountById(13L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_8_subject,
            body = R.string.email_8_body,
            createdAt = R.string.email_8_time,
        ),
        Email(
            id = 9L,
            sender = LocalAccountsDataProvider.getContactAccountById(10L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_9_subject,
            body = R.string.email_9_body,
            createdAt = R.string.email_9_time,
            mailbox = MailboxType.Drafts // Este correo está en borradores
        ),
        Email(
            id = 10L,
            sender = LocalAccountsDataProvider.getContactAccountById(5L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_10_subject,
            body = R.string.email_10_body,
            createdAt = R.string.email_10_time,
        ),
        Email(
            id = 11L,
            sender = LocalAccountsDataProvider.getContactAccountById(5L),
            recipients = listOf(LocalAccountsDataProvider.defaultAccount),
            subject = R.string.email_11_subject,
            body = R.string.email_11_body,
            createdAt = R.string.email_11_time,
            mailbox = MailboxType.Spam // Este correo está en el buzón de spam
        )
    )

    /**
     * Devuelve un [Email] por su ID.
     *
     * @param id Identificador único del correo a buscar
     * @return El correo correspondiente o null si no se encuentra
     */
    fun get(id: Long): Email? {
        return allEmails.firstOrNull { it.id == id }
    }

    /**
     * Correo predeterminado que se usa como valor por defecto si no hay selección.
     */
    val defaultEmail = Email(
        id = -1,
        sender = LocalAccountsDataProvider.defaultAccount
    )
}
