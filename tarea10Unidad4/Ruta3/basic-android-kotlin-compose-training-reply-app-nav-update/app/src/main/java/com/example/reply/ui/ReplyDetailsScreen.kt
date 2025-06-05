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
package com.example.reply.ui

// Importación de elementos necesarios de Compose para construir la UI y manejar eventos.
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.MailboxType

// Composable principal que representa la pantalla de detalles del correo.
@Composable
fun ReplyDetailsScreen(
    replyUiState: ReplyUiState, // Estado actual de la UI proveniente del ViewModel
    onBackPressed: () -> Unit, // Acción que se ejecuta cuando se pulsa "atrás"
    modifier: Modifier = Modifier, // Modificador para aplicar estilo y layout
) {
    // Intercepta el botón de retroceso para ejecutar onBackPressed personalizado
    BackHandler {
        onBackPressed()
    }

    // Contenedor principal de la pantalla
    Box(modifier = modifier) {
        // Lista perezosa que permite desplazamiento vertical
        LazyColumn(
            contentPadding = WindowInsets.safeDrawing.asPaddingValues(), // Respeta las zonas seguras del dispositivo
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface) // Fondo estilizado según tema
        ) {
            // Único item de la lista que contiene el contenido completo
            item {
                // TopBar con botón de regreso y asunto del correo
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
                // Tarjeta con los detalles completos del correo
                ReplyEmailDetailsCard(
                    email = replyUiState.currentSelectedEmail,
                    mailboxType = replyUiState.currentMailbox,
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(horizontal = dimensionResource(R.dimen.detail_card_outer_padding_horizontal))
                )
            }
        }
    }
}

// Barra superior con botón de retroceso y asunto del correo
@Composable
private fun ReplyDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,
    replyUiState: ReplyUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Botón circular con ícono de regreso
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }
        // Asunto del correo centrado horizontalmente
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

// Tarjeta principal con detalles del correo y botones de acción según el buzón
@Composable
private fun ReplyEmailDetailsCard(
    email: Email,
    mailboxType: MailboxType,
    modifier: Modifier = Modifier,
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
            // Encabezado con imagen y datos del remitente
            DetailsScreenHeader(
                email,
                Modifier.fillMaxWidth()
            )
            // Asunto
            Text(
                text = stringResource(email.subject),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.detail_content_padding_top),
                    bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing)
                ),
            )
            // Cuerpo del correo
            Text(
                text = stringResource(email.body),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            // Botonera según tipo de buzón
            DetailsScreenButtonBar(mailboxType, displayToast)
        }
    }
}

// Barra inferior con botones que varían según el tipo de buzón
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
                        .padding(
                            vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)
                        ),
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
                        .padding(
                            vertical = dimensionResource(R.dimen.detail_button_bar_padding_vertical)
                        ),
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

// Encabezado del correo con avatar, nombre y fecha
@Composable
private fun DetailsScreenHeader(email: Email, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        ReplyProfileImage(
            drawableResource = email.sender.avatar,
            description = stringResource(email.sender.firstName) + " "
                    + stringResource(email.sender.lastName),
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

// Botón reutilizable con estilos diferenciados según si es una acción irreversible
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
                containerColor =
                if (containIrreversibleAction) {
                    MaterialTheme.colorScheme.onErrorContainer
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                }
            )
        ) {
            Text(
                text = text,
                color =
                if (containIrreversibleAction) {
                    MaterialTheme.colorScheme.onError
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}