/*
 * Copyright (C) 2023 The Android Open Source Project
 * Licencia Apache 2.0
 */

package com.example.busschedule.ui

// Importaciones necesarias para Compose, navegación, temas, etc.
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.busschedule.R
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.ui.theme.BusScheduleTheme
import java.text.SimpleDateFormat
import java.util.*

/**
 * Enum que define las pantallas disponibles en la app.
 */
enum class BusScheduleScreens {
    FullSchedule,
    RouteSchedule
}

/**
 * Función principal de la app que configura la navegación y la barra superior.
 */
@Composable
fun BusScheduleApp(
    viewModel: BusScheduleViewModel = viewModel(factory = BusScheduleViewModel.factory)
) {
    val navController = rememberNavController()
    val fullScheduleTitle = stringResource(R.string.full_schedule)
    var topAppBarTitle by remember { mutableStateOf(fullScheduleTitle) }

    val fullSchedule by viewModel.getFullSchedule().collectAsState(emptyList())

    val onBackHandler = {
        topAppBarTitle = fullScheduleTitle
        navController.navigateUp()
    }

    Scaffold(
        topBar = {
            BusScheduleTopAppBar(
                title = topAppBarTitle,
                canNavigateBack = navController.previousBackStackEntry != null,
                onBackClick = { onBackHandler() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BusScheduleScreens.FullSchedule.name
        ) {
            composable(BusScheduleScreens.FullSchedule.name) {
                FullScheduleScreen(
                    busSchedules = fullSchedule,
                    contentPadding = innerPadding,
                    onScheduleClick = { busStopName ->
                        navController.navigate("${BusScheduleScreens.RouteSchedule.name}/$busStopName")
                        topAppBarTitle = busStopName
                    }
                )
            }

            val busRouteArgument = "busRoute"
            composable(
                route = BusScheduleScreens.RouteSchedule.name + "/{$busRouteArgument}",
                arguments = listOf(navArgument(busRouteArgument) { type = NavType.StringType })
            ) { backStackEntry ->
                val stopName = backStackEntry.arguments?.getString(busRouteArgument)
                    ?: error("busRouteArgument cannot be null")
                val routeSchedule by viewModel.getScheduleFor(stopName).collectAsState(emptyList())
                RouteScheduleScreen(
                    stopName = stopName,
                    busSchedules = routeSchedule,
                    contentPadding = innerPadding,
                    onBack = { onBackHandler() }
                )
            }
        }
    }
}

/**
 * Pantalla que muestra todos los horarios disponibles.
 */
@Composable
fun FullScheduleScreen(
    busSchedules: List<BusSchedule>,
    onScheduleClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    BusScheduleScreen(
        busSchedules = busSchedules,
        onScheduleClick = onScheduleClick,
        contentPadding = contentPadding,
        modifier = modifier
    )
}

/**
 * Pantalla que muestra los horarios filtrados por una parada específica.
 */
@Composable
fun RouteScheduleScreen(
    stopName: String,
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onBack: () -> Unit = {}
) {
    BackHandler { onBack() }
    BusScheduleScreen(
        busSchedules = busSchedules,
        modifier = modifier,
        contentPadding = contentPadding,
        stopName = stopName
    )
}

/**
 * Pantalla genérica que representa la lista de horarios (todos o por parada).
 */
@Composable
fun BusScheduleScreen(
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    stopName: String? = null,
    onScheduleClick: ((String) -> Unit)? = null,
) {
    val stopNameText = if (stopName == null) {
        stringResource(R.string.stop_name)
    } else {
        "$stopName ${stringResource(R.string.route_stop_name)}"
    }
    val layoutDirection = LocalLayoutDirection.current

    Column(
        modifier = modifier.padding(
            start = contentPadding.calculateStartPadding(layoutDirection),
            end = contentPadding.calculateEndPadding(layoutDirection),
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    bottom = dimensionResource(R.dimen.padding_medium),
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium),
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stopNameText)
            Text(stringResource(R.string.arrival_time))
        }
        Divider()
        BusScheduleDetails(
            contentPadding = PaddingValues(
                bottom = contentPadding.calculateBottomPadding()
            ),
            busSchedules = busSchedules,
            onScheduleClick = onScheduleClick
        )
    }
}

/**
 * Muestra los detalles del horario en una lista scrollable.
 */
@Composable
fun BusScheduleDetails(
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onScheduleClick: ((String) -> Unit)? = null
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
    ) {
        items(
            items = busSchedules,
            key = { busSchedule -> busSchedule.id }
        ) { schedule ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = onScheduleClick != null) {
                        onScheduleClick?.invoke(schedule.stopName)
                    }
                    .padding(dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (onScheduleClick == null) {
                    Text(
                        text = "--",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = dimensionResource(R.dimen.font_large).value.sp,
                            fontWeight = FontWeight(300)
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Text(
                        text = schedule.stopName,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = dimensionResource(R.dimen.font_large).value.sp,
                            fontWeight = FontWeight(300)
                        )
                    )
                }
                Text(
                    text = SimpleDateFormat("h:mm a", Locale.getDefault())
                        .format(Date(schedule.arrivalTimeInMillis.toLong() * 1000)),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = dimensionResource(R.dimen.font_large).value.sp,
                        fontWeight = FontWeight(600)
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(2f)
                )
            }
        }
    }
}

/**
 * Barra superior personalizada con o sin botón de regreso.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusScheduleTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (canNavigateBack) {
        TopAppBar(
            title = { Text(title) },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            },
            modifier = modifier
        )
    } else {
        TopAppBar(
            title = { Text(title) },
            modifier = modifier
        )
    }
}

/**
 * Vista previa de la pantalla de todos los horarios.
 */
@Preview(showBackground = true)
@Composable
fun FullScheduleScreenPreview() {
    BusScheduleTheme {
        FullScheduleScreen(
            busSchedules = List(3) { index ->
                BusSchedule(index, "Main Street", 111111)
            },
            onScheduleClick = {}
        )
    }
}

/**
 * Vista previa de la pantalla filtrada por parada.
 */
@Preview(showBackground = true)
@Composable
fun RouteScheduleScreenPreview() {
    BusScheduleTheme {
        RouteScheduleScreen(
            stopName = "Main Street",
            busSchedules = List(3) { index ->
                BusSchedule(index, "Main Street", 111111)
            }
        )
    }
}
