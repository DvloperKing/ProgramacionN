fun main() {
    val numeros = listOf(1, 2, 3, 4, 5)

    // map: aplica una transformación a cada elemento
    val cuadrados = numeros.map { it * it }

    // filter: selecciona los elementos que cumplan una condición
    val pares = numeros.filter { it % 2 == 0 }

    println("Cuadrados: $cuadrados") // [1, 4, 9, 16, 25]
    println("Pares: $pares")         // [2, 4]
}