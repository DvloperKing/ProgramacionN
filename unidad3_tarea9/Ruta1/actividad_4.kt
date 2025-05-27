// Actividad 4: Agrupar por tipo en un mapa
// Agrupamos los anfibios por su propiedad `type` y mostramos los nombres organizados por categoría

/**
 * Agrupación de anfibios por tipo
 *
 * Utilizamos la función `groupBy` para convertir una lista de `Amphibian` en un `Map<String, List<Amphibian>>`,
 * donde cada clave es un tipo taxonómico (por ejemplo: "Anuro", "Caudado"), y el valor es la lista de anfibios de ese tipo.
 */
val agrupados: Map<String, List<Amphibian>> = amphibians.groupBy { it.type }

/**
 * Recorrido del mapa agrupado
 *
 * Usamos `forEach` para iterar sobre cada entrada del mapa.
 * Cada clave (`tipo`) representa una categoría taxonómica.
 * Cada valor (`lista`) es la lista de anfibios asociados a ese tipo.
 */
agrupados.forEach { (tipo, lista) ->
    println("Tipo: $tipo")
    lista.forEach { println(" - ${it.name}") }  // Imprime los nombres de los anfibios agrupados
}
