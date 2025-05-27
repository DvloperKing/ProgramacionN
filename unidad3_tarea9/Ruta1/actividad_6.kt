/**
 * Composable AmphibianCard
 *
 * Muestra la información de un objeto `Amphibian` dentro de una tarjeta visual (Card),
 * utilizando una estructura de columna y estilos del tema actual de Material Design.
 *
 * @param amphibian Objeto de tipo `Amphibian` con los datos a mostrar
 */
@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
            .padding(8.dp)               // Espacio externo entre tarjetas
            .fillMaxWidth(),             // Ocupa todo el ancho disponible
        elevation = CardDefaults.cardElevation(4.dp) // Sombra para resaltar
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = amphibian.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = amphibian.type,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

/**
 * Composable AmphibianList
 *
 * Despliega una lista de objetos `Amphibian` utilizando un `LazyColumn`,
 * que renderiza los elementos de forma eficiente (solo los visibles en pantalla).
 *
 * @param amphibians Lista de objetos `Amphibian` a mostrar
 */
@Composable
fun AmphibianList(amphibians: List<Amphibian>) {
    LazyColumn {
        items(amphibians) { amphibian ->
            AmphibianCard(amphibian)  // Cada item se muestra en su propia tarjeta
        }
    }
}
/**
 * Composable MainScreen
 *
 * Pantalla principal que muestra una lista de anfibios utilizando el tema Material Design.
 * Utiliza `Scaffold` para estructurar la interfaz con una barra de título y un contenido principal.
 *
 * @param amphibians Lista de objetos `Amphibian` a mostrar
 */
@Composable
fun MainScreen() {
    val sampleData = listOf(
        Amphibian("Sapo", "Anuro", "Animal que salta y croa"),
        Amphibian("Tritón", "Caudado", "Amphibio con cola")
    )
    AmphibianList(amphibians = sampleData)
}

