import java.util.Arrays

fun main() {
    // Array genérico de Strings con valores iniciales
    val strings = Array(5) { index -> "Elemento #$index" }
    println(Arrays.toString(strings)) // [Elemento #0, Elemento #1, Elemento #2, Elemento #3, Elemento #4]

    // Modificar un elemento
    strings[2] = "Elemento Modificado"
    println("Elemento en la posición 2: ${strings[2]}")

    // Array primitivo de enteros
    val enteros = intArrayOf(1, 2, 3, 4)
    println("Promedio: ${enteros.average()}") // 2.5

    // Orden descendente
    val ordenados = enteros.sortedArrayDescending()
    println("Orden descendente: ${ordenados.joinToString()}") // 4, 3, 2, 1

    // Uso de componentN
    val componentes = arrayOf("A", "B", "C")
    val (primero, segundo, tercero) = componentes
    println("Primer componente: $primero, Segundo: $segundo, Tercero: $tercero")

    // Crear array con valores calculados
    val cuadrados = Array(5) { i -> (i * i).toString() }
    for (s in cuadrados) {
        println("Valor cuadrado como string: $s")
    }

    // getOrNull para evitar excepción
    val valorSeguro = enteros.getOrNull(10) ?: "Fuera de rango"
    println("Valor seguro en índice 10: $valorSeguro")
}
