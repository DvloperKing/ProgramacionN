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

package com.example.reply.test // Paquete de pruebas del proyecto Reply

/**
 * Anotación personalizada para identificar pruebas diseñadas para pantallas compactas.
 *
 * Se puede usar con herramientas de prueba o filtrar resultados en suites de test.
 */
annotation class TestCompactWidth

/**
 * Anotación personalizada para identificar pruebas diseñadas para pantallas de tamaño medio.
 */
annotation class TestMediumWidth

/**
 * Anotación personalizada para identificar pruebas diseñadas para pantallas expandidas (grandes).
 */
annotation class TestExpandedWidth
