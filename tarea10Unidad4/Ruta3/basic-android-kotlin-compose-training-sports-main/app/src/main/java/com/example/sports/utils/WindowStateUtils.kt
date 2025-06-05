/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache 2.0. Puedes obtener una copia en:
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Este archivo se proporciona "TAL CUAL", sin garantías explícitas o implícitas.
 */

package com.example.sports.utils // Define el paquete al que pertenece este archivo

/**
 * Enumeración que representa los tipos de contenido que se pueden mostrar
 * dependiendo del tamaño de pantalla del dispositivo y del estado de navegación.
 */
enum class SportsContentType {
    ListOnly,       // Solo se muestra la lista (por ejemplo, en pantallas pequeñas o medianas)
    ListAndDetail   // Se muestran simultáneamente la lista y los detalles (en pantallas grandes)
}
