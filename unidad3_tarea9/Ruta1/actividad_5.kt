// Actividad 5: Función personalizada de orden superior
// Definimos una función reutilizable que recibe una lista de objetos `Amphibian`
// y una acción (función lambda) a ejecutar por cada uno de ellos.

/**
 * Función de orden superior `procesar`
 *
 * @param amphibians Lista de objetos de tipo `Amphibian`
 * @param accion Función lambda que se aplicará a cada elemento de la lista
 *
 * Esta función itera sobre la lista y aplica la acción provista a cada objeto.
 * Es útil para abstraer lógica repetitiva como impresión, validación, renderizado, etc.
 */
fun procesar(amphibians: List<Amphibian>, accion: (Amphibian) -> Unit) {
    for (a in amphibians) accion(a)  // Se ejecuta la acción recibida como parámetro
}

// Uso de la función `procesar` con una lambda
// En este caso, simplemente imprimimos la descripción de cada anfibio

procesar(amphibians) { println(it.description) }
