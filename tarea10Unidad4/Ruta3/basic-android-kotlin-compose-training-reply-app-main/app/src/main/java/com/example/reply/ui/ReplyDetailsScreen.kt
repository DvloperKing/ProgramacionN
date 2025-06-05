/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No se puede utilizar este archivo excepto de acuerdo con la Licencia.
 * Se puede obtener una copia de la Licencia en:
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo requiera la ley aplicable o se acuerde por escrito,
 * el software distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 */

package com.example.reply.ui

// Importaciones necesarias para la interfaz de usuario, componentes de Jetpack Compose,
// íconos, recursos de string y dimensión, y acceso al contexto actual
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.MailboxType

/**
 * Composable principal que representa la pantalla de detalles del correo.
 */
@Composable
fun ReplyDetailsScreen(
    replyUiState: ReplyUiState,         // Estado actual de la interfaz de usuario
    onBackPressed: () -> Unit,          // Callback para manejar evento de retroceso
    modifier: Modifier = Modifier,      // Modificador opcional para personalización
    isFullScreen: Boolean = false       // Indica si se muestra en pantalla completa
) {
    // Maneja la acción del botón de retroceso del sistema
    BackHandler {
        onBackPressed()
    }

    // Contenedor principal de la pantalla
    Box(modifier = modifier) {
        LazyColumn(
            // Padding seguro considerando la barra de estado
            contentPadding = PaddingValues(
                top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding(),
            ),
            modifier = Modifier
                .testTag(stringResource(R.string.details_screen)) // Identificador para pruebas
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface) // Fondo
        ) {
            item {
                // Si es pantalla completa, mostrar la barra superior personalizada
                if (isFullScreen) {
                    ReplyDetailsScreenTopBar(
                        onBackPressed,
                        replyUiState,
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = dimensionResource(R.dimen.detail_topbar_padding_bottom),
                                top = dimensionResource(R.dimen.topbar_padding_vertical)
                            )
                    )
                }

                // Tarjeta que contiene los detalles del correo
                ReplyEmailDetailsCard(
                    email = replyUiState.currentSelectedEmail,
                    mailboxType = replyUiState.currentMailbox,
                    isFullScreen = isFullScreen,
                    modifier = if (isFullScreen) {
                        Modifier.padding(horizontal = dimensionResource(R.dimen.detail_card_outer_padding_horizontal))
                    } else {
                        Modifier
                    }
                )
            }
        }
    }
}

/**
 * Barra superior personalizada que incluye botón de retroceso y asunto.
 */
@Composable
private fun ReplyDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,    // Callback del botón de retroceso
    replyUiState: ReplyUiState,         // Estado actual
    modifier: Modifier = Modifier       // Modificador opcional
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Botón de retroceso con ícono circular
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }

        // Asunto del correo centrado
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = dimensionResource(R.dimen.detail_subject_padding_end))
        ) {
            Text(
                text = stringResource(replyUiState.currentSelectedEmail.subject),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Tarjeta que muestra los detalles del correo electrónico seleccionado.
 */
@Composable
private fun ReplyEmailDetailsCard(
    email: Email,                       // Correo actual
    mailboxType: MailboxType,          // Tipo de buzón (Inbox, Spam, etc.)
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false
) {
    val context = LocalContext.current
    val displayToast = { text: String ->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.detail_card_inner_padding))
        ) {
            // Encabezado con avatar, nombre y fecha
            DetailsScreenHeader(email, Modifier.fillMaxWidth())

            // Asunto si no es pantalla completa
            if (isFullScreen) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.detail_content_padding_top)))
            } else {
                Text(
                    text = stringResource(email.subject),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.detail_content_padding_top),
                        bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing)
                    ),
                )
            }

            // Cuerpo del correo
            Text(
                text = stringResource(email.body),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            // Botones de acción (Responder, Eliminar, etc.)
            DetailsScreenButtonBar(mailboxType, displayToast)
        }
    }
}

/**
 * Sección de botones al final de la tarjeta según el tipo de buzón.
 */
@Composable
private fun DetailsScreenButtonBar(
    mailboxType: MailboxType,
    displayToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        when (mailboxType) {
            MailboxType.Drafts ->
                ActionButton(
                    text = stringResource(id = R.string.continue_composing),
                    onButtonClicked = displayToast
                )

            MailboxType.Spam ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)),
                    horizontalArrangement = Arrangement.spacedBy(
                        dimensionResource(R.dimen.detail_button_bar_item_spacing)
                    ),
                ) {
                    ActionButton(
                        text = stringResource(id = R.string.move_to_inbox),
                        onButtonClicked = displayToast,
                        modifier = Modifier.weight(1f)
                    )
                    ActionButton(
                        text = stringResource(id = R.string.delete),
                        onButtonClicked = displayToast,
                        containIrreversibleAction = true,
                        modifier = Modifier.weight(1f)
                    )
                }

            MailboxType.Sent, MailboxType.Inbox ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)),
                    horizontalArrangement = Arrangement.spacedBy(
                        dimensionResource(R.dimen.detail_button_bar_item_spacing)
                    ),
                ) {
                    ActionButton(
                        text = stringResource(id = R.string.reply),
                        onButtonClicked = displayToast,
                        modifier = Modifier.weight(1f)
                    )
                    ActionButton(
                        text = stringResource(id = R.string.reply_all),
                        onButtonClicked = displayToast,
                        modifier = Modifier.weight(1f)
                    )
                }
        }
    }
}

/**
 * Encabezado de la tarjeta con imagen de perfil, nombre y fecha.
 */
@Composable
private fun DetailsScreenHeader(email: Email, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        ReplyProfileImage(
            drawableResource = email.sender.avatar,
            description = stringResource(email.sender.firstName) + " " +
                          stringResource(email.sender.lastName),
            modifier = Modifier.size(
                dimensionResource(R.dimen.email_header_profile_size)
            )
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = dimensionResource(R.dimen.email_header_content_padding_horizontal),
                    vertical = dimensionResource(R.dimen.email_header_content_padding_vertical)
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(email.sender.firstName),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = stringResource(email.createdAt),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

/**
 * Botón de acción reutilizable con colores según la criticidad.
 */
@Composable
private fun ActionButton(
    text: String,
    onButtonClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    containIrreversibleAction: Boolean = false,
) {
    Box(modifier = modifier) {
        Button(
            onClick = { onButtonClicked(text) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.detail_action_button_padding_vertical)),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (containIrreversibleAction)
                    MaterialTheme.colorScheme.onErrorContainer
                else
                    MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = text,
                color = if (containIrreversibleAction)
                    MaterialTheme.colorScheme.onError
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
