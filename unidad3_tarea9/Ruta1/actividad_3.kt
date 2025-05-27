// Actividad 3: Filtrar por tipo
// Mostramos solo los anfibios que son de tipo "Anuro" usando programación funcional

/**
 * Filtro de anfibios tipo "Anuro"
 *
 * Utilizamos la función de orden superior `filter` para recorrer la lista de anfibios
 * y seleccionar únicamente aquellos cuya propiedad `type` sea igual a "Anuro".
 * El resultado es una nueva lista que puede usarse para visualización, estadísticas, etc.
 */
val anuros = amphibians.filter { it.type == "Anuro" }  // Devuelve solo los de tipo "Anuro"

/**
 * Recorrido de la lista filtrada
 *
 * Usamos `forEach` para imprimir el nombre de cada anfibio resultante del filtro.
 * Esto es útil para verificar visualmente que el filtro ha funcionado correctamente.
 */
anuros.forEach { println(it.name) }  // Imprime: Sapo
