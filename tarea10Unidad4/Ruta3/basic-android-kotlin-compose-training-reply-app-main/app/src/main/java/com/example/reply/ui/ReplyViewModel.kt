/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define el ViewModel para la app Reply.
 * Administra y expone el estado de la UI usando StateFlow.
 */

package com.example.reply.ui

// Importaciones necesarias para ViewModel, manejo de datos y flujos reactivos
import androidx.lifecycle.ViewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel que gestiona el estado de la interfaz de usuario en la aplicación Reply.
 * Utiliza StateFlow para exponer un estado observable de forma segura e inmutable.
 */
class ReplyViewModel : ViewModel() {

    // Estado interno mutable de la UI
    private val _uiState = MutableStateFlow(ReplyUiState())

    // Estado expuesto al exterior de forma inmutable (sólo lectura)
    val uiState: StateFlow<ReplyUiState> = _uiState

    // Inicializa el estado una vez se crea la instancia del ViewModel
    init {
        initializeUIState()
    }

    /**
     * Carga inicial de datos:
     * Agrupa todos los correos disponibles por tipo de buzón y selecciona el primer correo del Inbox.
     */
    private fun initializeUIState() {
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox }

        _uiState.value = ReplyUiState(
            mailboxes = mailboxes,
            currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0)
                ?: LocalEmailsDataProvider.defaultEmail // fallback si Inbox está vacío
        )
    }

    /**
     * Cambia el estado para mostrar la pantalla de detalle de un correo específico.
     *
     * @param email Correo que se ha seleccionado
     */
    fun updateDetailsScreenStates(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail = email,
                isShowingHomepage = false // Oculta la lista, muestra detalle
            )
        }
    }

    /**
     * Restaura el estado a la vista de lista principal (homepage).
     * Vuelve a seleccionar el primer correo del buzón actual.
     */
    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail,
                isShowingHomepage = true // Vuelve a mostrar la pantalla principal
            )
        }
    }

    /**
     * Actualiza el buzón actualmente seleccionado (Inbox, Sent, etc.).
     *
     * @param mailboxType El buzón a mostrar
     */
    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update {
            it.copy(currentMailbox = mailboxType)
        }
    }
}
