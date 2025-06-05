/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Este archivo forma parte del proyecto Android Reply.
 * Define la estructura de navegación principal de la aplicación: 
 * Navigation Drawer, Navigation Rail y Bottom Navigation.
 */

package com.example.reply.ui

// Importación de componentes de UI, navegación y recursos
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Drafts
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.reply.R
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalAccountsDataProvider
import com.example.reply.ui.utils.ReplyContentType
import com.example.reply.ui.utils.ReplyNavigationType

/**
 * Pantalla principal del sistema de correo.
 * Muestra una lista de correos, sus detalles, y la navegación correspondiente
 * según el tipo de dispositivo.
 */
@Composable
fun ReplyHomeScreen(
    navigationType: ReplyNavigationType, // Tipo de navegación (drawer, rail, bottom)
    contentType: ReplyContentType,       // Tipo de contenido (solo lista o lista + detalle)
    replyUiState: ReplyUiState,          // Estado actual de la interfaz
    onTabPressed: (MailboxType) -> Unit, // Acción al cambiar de buzón
    onEmailCardPressed: (Email) -> Unit, // Acción al seleccionar un correo
    onDetailScreenBackPressed: () -> Unit, // Acción al regresar del detalle en móviles
    modifier: Modifier = Modifier
) {
    // Lista de elementos de navegación (buzones)
    val navigationItemContentList = listOf(
        NavigationItemContent(MailboxType.Inbox, Icons.Default.Inbox, stringResource(id = R.string.tab_inbox)),
        NavigationItemContent(MailboxType.Sent, Icons.Default.Send, stringResource(id = R.string.tab_sent)),
        NavigationItemContent(MailboxType.Drafts, Icons.Default.Drafts, stringResource(id = R.string.tab_drafts)),
        NavigationItemContent(MailboxType.Spam, Icons.Default.Report, stringResource(id = R.string.tab_spam))
    )

    // Si se utiliza Drawer permanente (pantalla grande tipo desktop)
    if (navigationType == ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)

        // Drawer visible todo el tiempo
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(
                    modifier = Modifier.width(dimensionResource(R.dimen.drawer_width)),
                    drawerContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                ) {
                    // Contenido del drawer
                    NavigationDrawerContent(
                        selectedDestination = replyUiState.currentMailbox,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(R.dimen.drawer_padding_content))
                    )
                }
            },
            modifier = Modifier.testTag(navigationDrawerContentDescription)
        ) {
            ReplyAppContent(
                navigationType, contentType, replyUiState,
                onTabPressed, onEmailCardPressed,
                navigationItemContentList, modifier
            )
        }
    } else {
        // Para dispositivos móviles o tablets (Drawer no permanente)
        if (replyUiState.isShowingHomepage) {
            ReplyAppContent(
                navigationType, contentType, replyUiState,
                onTabPressed, onEmailCardPressed,
                navigationItemContentList, modifier
            )
        } else {
            // Solo muestra detalle si está en modo pantalla completa
            ReplyDetailsScreen(
                replyUiState = replyUiState,
                onBackPressed = onDetailScreenBackPressed,
                modifier = modifier,
                isFullScreen = true
            )
        }
    }
}

/**
 * Componente central que gestiona el layout según el tipo de navegación.
 */
@Composable
private fun ReplyAppContent(
    navigationType: ReplyNavigationType,
    contentType: ReplyContentType,
    replyUiState: ReplyUiState,
    onTabPressed: (MailboxType) -> Unit,
    onEmailCardPressed: (Email) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Barra lateral (solo visible si es NavigationRail)
            AnimatedVisibility(visible = navigationType == ReplyNavigationType.NAVIGATION_RAIL) {
                val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                ReplyNavigationRail(
                    currentTab = replyUiState.currentMailbox,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier.testTag(navigationRailContentDescription)
                )
            }

            // Área principal de contenido
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                // Determina si se muestra solo lista o lista con detalle
                if (contentType == ReplyContentType.LIST_AND_DETAIL) {
                    ReplyListAndDetailContent(
                        replyUiState = replyUiState,
                        onEmailCardPressed = onEmailCardPressed,
                        modifier = Modifier
                            .statusBarsPadding()
                            .weight(1f),
                    )
                } else {
                    ReplyListOnlyContent(
                        replyUiState = replyUiState,
                        onEmailCardPressed = onEmailCardPressed,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding))
                    )
                }

                // Barra de navegación inferior (solo visible en móviles)
                AnimatedVisibility(visible = navigationType == ReplyNavigationType.BOTTOM_NAVIGATION) {
                    val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
                    ReplyBottomNavigationBar(
                        currentTab = replyUiState.currentMailbox,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag(bottomNavigationContentDescription)
                    )
                }
            }
        }
    }
}

/**
 * Componente para NavigationRail (lateral) usado en tablets.
 */
@Composable
private fun ReplyNavigationRail(
    currentTab: MailboxType,
    onTabPressed: (MailboxType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.text)
                }
            )
        }
    }
}

/**
 * Componente para la barra de navegación inferior (móviles).
 */
@Composable
private fun ReplyBottomNavigationBar(
    currentTab: MailboxType,
    onTabPressed: (MailboxType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.text)
                }
            )
        }
    }
}

/**
 * Contenido del Drawer permanente con encabezado y lista de buzones.
 */
@Composable
private fun NavigationDrawerContent(
    selectedDestination: MailboxType,
    onTabPressed: (MailboxType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.profile_image_padding)),
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.mailboxType,
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                    )
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.text)
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.mailboxType) }
            )
        }
    }
}

/**
 * Encabezado del Drawer con logo de la app y avatar de usuario.
 */
@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ReplyLogo(modifier = Modifier.size(dimensionResource(R.dimen.reply_logo_size)))
        ReplyProfileImage(
            drawableResource = LocalAccountsDataProvider.defaultAccount.avatar,
            description = stringResource(id = R.string.profile),
            modifier = Modifier.size(dimensionResource(R.dimen.profile_image_size))
        )
    }
}

/**
 * Clase auxiliar para representar cada ítem de navegación (Inbox, Drafts, etc.).
 */
private data class NavigationItemContent(
    val mailboxType: MailboxType,     // Tipo de buzón
    val icon: ImageVector,            // Icono gráfico
    val text: String                  // Texto descriptivo
)
