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

package com.example.reply.ui // Paquete de UI de la aplicación

// Importaciones necesarias para composición, estado, tamaños de pantalla y modelo de datos
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.ui.utils.ReplyContentType
import com.example.reply.ui.utils.ReplyNavigationType

/**
 * Función composable principal que representa toda la interfaz de usuario de la aplicación Reply.
 *
 * Se adapta automáticamente al tamaño de pantalla del dispositivo utilizando tipos de navegación
 * y contenido distintos para ofrecer una experiencia optimizada.
 *
 * @param windowSize Clasificación del ancho de pantalla del dispositivo (Compact, Medium, Expanded)
 * @param modifier Modificador opcional para aplicar estilos externos al componente raíz
 */
@Composable
fun ReplyApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    // Variables que definen el tipo de navegación y contenido según el tamaño de pantalla
    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType

    // Instancia del ViewModel para obtener el estado actual de la UI
    val viewModel: ReplyViewModel = viewModel()
    val replyUiState = viewModel.uiState.collectAsState().value // Observa los cambios de estado

    // Asignación de navegación y tipo de contenido de acuerdo al ancho de pantalla
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ReplyContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }

    // Llamada al composable principal que construye la UI completa según los parámetros anteriores
    ReplyHomeScreen(
        navigationType = navigationType, // Define si se usa BottomNav, Rail o Drawer
        contentType = contentType,       // Define si se muestra solo lista o también detalle
        replyUiState = replyUiState,     // Estado actual del buzón y selección
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.updateCurrentMailbox(mailboxType = mailboxType) // Cambia de buzón
            viewModel.resetHomeScreenStates() // Limpia selección de correo y otros estados
        },
        onEmailCardPressed = { email: Email ->
            viewModel.updateDetailsScreenStates(email = email) // Muestra correo en detalle
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates() // Regresa a lista sin selección activa
        },
        modifier = modifier // Permite estilos externos desde quien use ReplyApp()
    )
}
