/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia Apache 2.0: permite el uso del código con condiciones específicas.
 * Este archivo define componentes de UI para visualizar una lista de correos y su detalle.
 */

package com.example.reply.ui

// Importaciones necesarias para UI, recursos, y funciones de diseño en Jetpack Compose
import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.local.LocalAccountsDataProvider

/**
 * Muestra solo la lista de correos (modo de pantalla estrecha).
 */
@Composable
fun ReplyListOnlyContent(
    replyUiState: ReplyUiState,                         // Estado de UI con los correos
    onEmailCardPressed: (Email) -> Unit,                // Callback al presionar un correo
    modifier: Modifier = Modifier                       // Modificador externo
) {
    val emails = replyUiState.currentMailboxEmails      // Lista de correos del buzón actual

    LazyColumn(                                         // Lista vertical perezosa
        modifier = modifier,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.email_list_item_vertical_spacing)
        )
    ) {
        // Barra superior con logo y avatar
        item {
            ReplyHomeTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.topbar_padding_vertical))
            )
        }

        // Items de correo
        items(emails, key = { email -> email.id }) { email ->
            ReplyEmailListItem(
                email = email,
                selected = false,
                onCardClick = { onEmailCardPressed(email) }
            )
        }
    }
}

/**
 * Muestra lista y detalle del correo lado a lado (pantallas grandes).
 */
@Composable
fun ReplyListAndDetailContent(
    replyUiState: ReplyUiState,
    onEmailCardPressed: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    val emails = replyUiState.currentMailboxEmails

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Lista de correos en columna izquierda
        LazyColumn(
            contentPadding = WindowInsets.statusBars.asPaddingValues(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.email_list_item_vertical_spacing)
            )
        ) {
            items(emails, key = { email -> email.id }) { email ->
                ReplyEmailListItem(
                    email = email,
                    selected = replyUiState.currentSelectedEmail.id == email.id,
                    onCardClick = { onEmailCardPressed(email) }
                )
            }
        }

        // Detalle del correo en columna derecha
        val activity = LocalContext.current as Activity
        ReplyDetailsScreen(
            replyUiState = replyUiState,
            modifier = Modifier
                .weight(1f)
                .padding(end = dimensionResource(R.dimen.email_list_only_horizontal_padding)),
            onBackPressed = { activity.finish() }  // En pantallas grandes se cierra la actividad al presionar atrás
        )
    }
}

/**
 * Elemento individual que representa una tarjeta de correo en la lista.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyEmailListItem(
    email: Email,
    selected: Boolean,                   // Si está seleccionado (resaltado)
    onCardClick: () -> Unit,            // Callback al hacer clic
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = onCardClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.email_list_item_inner_padding))
        ) {
            // Encabezado con avatar, nombre y fecha
            ReplyEmailItemHeader(email, Modifier.fillMaxWidth())

            // Asunto
            Text(
                text = stringResource(email.subject),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.email_list_item_header_subject_spacing),
                    bottom = dimensionResource(R.dimen.email_list_item_subject_body_spacing)
                )
            )

            // Cuerpo (resumen con máximo 2 líneas)
            Text(
                text = stringResource(email.body),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Encabezado de un correo con avatar, nombre y fecha de envío.
 */
@Composable
private fun ReplyEmailItemHeader(email: Email, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        ReplyProfileImage(
            drawableResource = email.sender.avatar,
            description = stringResource(email.sender.firstName) + " " +
                          stringResource(email.sender.lastName),
            modifier = Modifier.size(dimensionResource(R.dimen.email_header_profile_size))
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
 * Imagen de perfil redonda reutilizable.
 */
@Composable
fun ReplyProfileImage(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.clip(CircleShape),     // Aplica forma circular
            painter = painterResource(drawableResource),
            contentDescription = description
        )
    }
}

/**
 * Logo de la aplicación con color personalizable.
 */
@Composable
fun ReplyLogo(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = stringResource(R.string.logo),
        colorFilter = ColorFilter.tint(color),         // Aplica el color al logo
        modifier = modifier
    )
}

/**
 * Barra superior de la pantalla principal con el logo y el avatar del usuario.
 */
@Composable
private fun ReplyHomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        // Logo de la app alineado a la izquierda
        ReplyLogo(
            modifier = Modifier
                .size(dimensionResource(R.dimen.topbar_logo_size))
                .padding(start = dimensionResource(R.dimen.topbar_logo_padding_start))
        )

        // Imagen de perfil del usuario alineada a la derecha
        ReplyProfileImage(
            drawableResource = LocalAccountsDataProvider.defaultAccount.avatar,
            description = stringResource(R.string.profile),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.topbar_profile_image_padding_end))
                .size(dimensionResource(R.dimen.topbar_profile_image_size))
        )
    }
}
