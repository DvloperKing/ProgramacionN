/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo define el punto central de la interfaz de usuario usando Jetpack Compose.
 * Establece la navegación según el tamaño de pantalla y conecta la UI con el ViewModel.
 */

package com.example.reply.ui

// Importación de clases necesarias para diseño adaptable, estado y navegación
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.ui.utils.ReplyNavigationType

/**
 * Punto de entrada composable para la interfaz principal de la app.
 *
 * @param windowSize Clase de tamaño de pantalla (Compact, Medium, Expanded)
 * @param modifier Modificador externo para aplicar estilos o padding
 */
@Composable
fun ReplyApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    // Declaración de variables necesarias
    val navigationType: ReplyNavigationType

    // ViewModel que contiene el estado de la UI
    val viewModel: ReplyViewModel = viewModel()

    // Se observa el flujo de estado expuesto por el ViewModel y se convierte a estado Compose
    val replyUiState = viewModel.uiState.collectAsState().value

    // Se determina el tipo de navegación según el tamaño de pantalla
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION // Teléfonos
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL    // Tablets medianas
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER // Pantallas grandes
        }
        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
        }
    }

    // Llama a la pantalla principal, pasando el tipo de navegación y callbacks de eventos
    ReplyHomeScreen(
        navigationType = navigationType,
        replyUiState = replyUiState,

        // Al cambiar de buzón, se actualiza el estado en el ViewModel
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.updateCurrentMailbox(mailboxType = mailboxType)
            viewModel.resetHomeScreenStates()
        },

        // Al seleccionar un correo, se muestra su detalle
        onEmailCardPressed = { email: Email ->
            viewModel.updateDetailsScreenStates(email = email)
        },

        // Al presionar atrás desde el detalle, se regresa a la pantalla principal
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },

        // Modificador opcional
        modifier = modifier
    )
}
