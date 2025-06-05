/*
 * Copyright (C) 2023 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 */

package com.example.lunchtray // Paquete base del proyecto, donde se agrupan componentes principales de la app

// Importaciones necesarias para el layout, navegación, componentes y ViewModel
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen

// Enumeración que define cada pantalla de la app con su título correspondiente (recurso StringRes)
enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Entree(title = R.string.choose_entree),
    SideDish(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}

/**
 * Composable que muestra la AppBar superior.
 * Incluye botón de retroceso si hay una pantalla anterior en el stack.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    @StringRes currentScreenTitle: Int, // Título actual de la pantalla
    canNavigateBack: Boolean,          // Si hay una pantalla anterior en la pila de navegación
    navigateUp: () -> Unit,            // Acción para volver hacia atrás
    modifier: Modifier = Modifier      // Modificador opcional para personalizar el layout
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) }, // Título centrado
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // Icono de flecha atrás
                        contentDescription = stringResource(R.string.back_button) // Accesibilidad
                    )
                }
            }
        }
    )
}

/**
 * Función composable principal que define la estructura general de navegación
 * y conexión del ViewModel con la interfaz de usuario.
 */
@Composable
fun LunchTrayApp() {
    val navController = rememberNavController() // Controlador de navegación que gestiona el flujo entre pantallas
    val backStackEntry by navController.currentBackStackEntryAsState() // Entrada actual en la pila de navegación

    // Determina la pantalla actual según la ruta en la entrada de la pila
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route ?: LunchTrayScreen.Start.name
    )

    // Instancia del ViewModel compartido entre pantallas
    val viewModel: OrderViewModel = viewModel()

    // Scaffold define la estructura general de la interfaz: AppBar y contenido
    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding -> // innerPadding asegura que el contenido no se superponga con la AppBar
        val uiState by viewModel.uiState.collectAsState() // Observa el estado del pedido

        // NavHost define las rutas de navegación y sus respectivas pantallas composables
        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier.padding(innerPadding) // Aplica padding interno del Scaffold
        ) {
            // Pantalla de inicio
            composable(route = LunchTrayScreen.Start.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(LunchTrayScreen.Entree.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Pantalla para seleccionar platillo principal (entree)
            composable(route = LunchTrayScreen.Entree.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.SideDish.name)
                    },
                    onSelectionChanged = { item -> viewModel.updateEntree(item) },
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }

            // Pantalla para seleccionar guarnición (side dish)
            composable(route = LunchTrayScreen.SideDish.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Accompaniment.name)
                    },
                    onSelectionChanged = { item -> viewModel.updateSideDish(item) },
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }

            // Pantalla para seleccionar acompañamiento (accompaniment)
            composable(route = LunchTrayScreen.Accompaniment.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Checkout.name)
                    },
                    onSelectionChanged = { item -> viewModel.updateAccompaniment(item) },
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }

            // Pantalla de resumen del pedido y confirmación (checkout)
            composable(route = LunchTrayScreen.Checkout.name) {
                CheckoutScreen(
                    orderUiState = uiState, // Pasa el estado del pedido
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(LunchTrayScreen.Start.name, inclusive = false)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                )
            }
        }
    }
}
