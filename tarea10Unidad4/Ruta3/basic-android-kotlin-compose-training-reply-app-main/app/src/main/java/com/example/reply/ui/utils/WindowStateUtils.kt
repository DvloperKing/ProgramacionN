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

package com.example.reply.ui.utils // Paquete que contiene utilidades para la UI adaptable

/**
 * Enumeración que define los diferentes tipos de navegación disponibles en la aplicación,
 * dependiendo del tamaño y estado de la pantalla del dispositivo.
 */
enum class ReplyNavigationType {
    /** Navegación inferior (BottomNavigation) — utilizada en pantallas compactas **/
    BOTTOM_NAVIGATION,

    /** Barra lateral vertical (NavigationRail) — para pantallas medianas **/
    NAVIGATION_RAIL,

    /** Menú lateral permanente (NavigationDrawer) — para pantallas grandes o extendidas **/
    PERMANENT_NAVIGATION_DRAWER
}

/**
 * Enumeración que determina el tipo de contenido que se muestra según el tamaño de la pantalla.
 */
enum class ReplyContentType {
    /** Solo la lista de correos es visible (modo teléfono o estrecho) **/
    LIST_ONLY,

    /** Lista de correos + vista de detalle simultáneamente (modo tablet o expandido) **/
    LIST_AND_DETAIL
}
