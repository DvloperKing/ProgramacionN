// Declaración de paquete
package com.example.sports.ui

// Imports de librerías necesarias para el uso de Jetpack Compose, Material Design y recursos del sistema
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sports.R
import com.example.sports.data.LocalSportsDataProvider
import com.example.sports.model.Sport
import com.example.sports.ui.theme.SportsTheme
import com.example.sports.utils.SportsContentType

/**
 * Composable principal que contiene la lógica para mostrar contenido
 * dependiendo del estado de la UI y el tamaño de pantalla.
 */
@Composable
fun SportsApp(
    windowSize: WindowWidthSizeClass, // Tamaño de ventana del dispositivo
    onBackPressed: () -> Unit // Acción a ejecutar al presionar "Atrás"
) {
    // Se obtiene el ViewModel que contiene el estado de la UI
    val viewModel: SportsViewModel = viewModel()
    // Se observa el estado actual de la UI
    val uiState by viewModel.uiState.collectAsState()

    // Determina si se mostrará solo la lista o lista + detalle
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> SportsContentType.ListOnly
        WindowWidthSizeClass.Expanded -> SportsContentType.ListAndDetail
        else -> SportsContentType.ListOnly
    }

    // Estructura base con barra superior
    Scaffold(
        topBar = {
            SportsAppBar(
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage() },
                windowSize = windowSize
            )
        }
    ) { innerPadding ->
        // Si se muestran lista y detalle (pantallas grandes)
        if (contentType == SportsContentType.ListAndDetail) {
            SportsListAndDetail(
                sports = uiState.sportsList,
                selectedSport = uiState.currentSport,
                onClick = { viewModel.updateCurrentSport(it) },
                onBackPressed = onBackPressed,
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            // En pantallas pequeñas: solo lista o solo detalle
            if (uiState.isShowingListPage) {
                SportsList(
                    sports = uiState.sportsList,
                    onClick = {
                        viewModel.updateCurrentSport(it)
                        viewModel.navigateToDetailPage()
                    },
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    contentPadding = innerPadding
                )
            } else {
                SportsDetail(
                    selectedSport = uiState.currentSport,
                    contentPadding = innerPadding,
                    onBackPressed = { viewModel.navigateToListPage() }
                )
            }
        }
    }
}

/**
 * Barra superior con título dinámico y botón de regreso si es necesario
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsAppBar(
    onBackButtonClick: () -> Unit, // Acción al presionar "Atrás"
    isShowingListPage: Boolean, // Estado actual: ¿se muestra la lista?
    windowSize: WindowWidthSizeClass, // Tamaño de ventana
    modifier: Modifier = Modifier
) {
    // Determina si se debe mostrar botón de regreso (en vista de detalle no expandida)
    val isShowingDetailPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingListPage

    TopAppBar(
        title = {
            Text(
                text = if (isShowingDetailPage)
                    stringResource(R.string.detail_fragment_label)
                else
                    stringResource(R.string.list_fragment_label),
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = if (isShowingDetailPage) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box {} } // No se muestra icono en modo lista
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

/**
 * Componente individual de la lista de deportes
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SportsListItem(
    sport: Sport,
    onItemClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(sport) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            // Imagen del deporte
            SportsListImageItem(
                sport = sport,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            // Texto informativo
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(sport.titleResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = stringResource(sport.subtitleResourceId),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                Spacer(Modifier.weight(1f))
                Row {
                    Text(
                        text = pluralStringResource(
                            R.plurals.player_count_caption,
                            sport.playerCount,
                            sport.playerCount
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.weight(1f))
                    if (sport.olympic) {
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

/**
 * Imagen mostrada en cada elemento de la lista
 */
@Composable
private fun SportsListImageItem(sport: Sport, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(sport.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

/**
 * Componente que muestra una lista de deportes
 */
@Composable
private fun SportsList(
    sports: List<Sport>,
    onClick: (Sport) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        items(sports, key = { it.id }) { sport ->
            SportsListItem(sport = sport, onItemClick = onClick)
        }
    }
}

/**
 * Pantalla de detalle para un deporte
 */
@Composable
private fun SportsDetail(
    selectedSport: Sport,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    // Soporta botón de atrás del sistema
    BackHandler { onBackPressed() }

    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current

    Box(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(top = contentPadding.calculateTopPadding())
    ) {
        Column(
            modifier = Modifier.padding(
                bottom = contentPadding.calculateTopPadding(),
                start = contentPadding.calculateStartPadding(layoutDirection),
                end = contentPadding.calculateEndPadding(layoutDirection)
            )
        ) {
            // Imagen con gradiente e información principal
            Box {
                Image(
                    painter = painterResource(selectedSport.sportsImageBanner),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ) {
                    Text(
                        text = stringResource(selectedSport.titleResourceId),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small))
                    )
                    Row(
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    ) {
                        Text(
                            text = pluralStringResource(
                                R.plurals.player_count_caption,
                                selectedSport.playerCount,
                                selectedSport.playerCount
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.inverseOnSurface
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = stringResource(R.string.olympic_caption),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.inverseOnSurface
                        )
                    }
                }
            }
            // Detalles extensos del deporte
            Text(
                text = stringResource(selectedSport.sportDetails),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_detail_content_vertical),
                    horizontal = dimensionResource(R.dimen.padding_detail_content_horizontal)
                )
            )
        }
    }
}

/**
 * Componente para pantallas grandes que muestra lista y detalle a la vez
 */
@Composable
private fun SportsListAndDetail(
    sports: List<Sport>,
    selectedSport: Sport,
    onClick: (Sport) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(modifier = modifier) {
        SportsList(
            sports = sports,
            onClick = onClick,
            contentPadding = PaddingValues(top = contentPadding.calculateTopPadding()),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        SportsDetail(
            selectedSport = selectedSport,
            modifier = Modifier.weight(3f),
            contentPadding = PaddingValues(top = contentPadding.calculateTopPadding()),
            onBackPressed = onBackPressed
        )
    }
}

// Previews para mostrar cómo se verá el diseño en el editor
@Preview
@Composable
fun SportsListItemPreview() {
    SportsTheme {
        SportsListItem(sport = LocalSportsDataProvider.defaultSport, onItemClick = {})
    }
}

@Preview
@Composable
fun SportsListPreview() {
    SportsTheme {
        Surface {
            SportsList(sports = LocalSportsDataProvider.getSportsData(), onClick = {})
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun SportsListAndDetailsPreview() {
    SportsTheme {
        Surface {
            SportsListAndDetail(
                sports = LocalSportsDataProvider.getSportsData(),
                selectedSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                    LocalSportsDataProvider.defaultSport
                },
                onClick = {},
                onBackPressed = {}
            )
        }
    }
}
