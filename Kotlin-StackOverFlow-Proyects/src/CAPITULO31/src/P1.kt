// Función que recibe un número variable de enteros usando vararg
fun printNumbers(vararg numbers: Int) {
    // Recorre cada número recibido y lo imprime
    for (number in numbers) {
        println(number)
    }
}

fun main() {
    // Llamada con dos parámetros individuales
    printNumbers(0, 1)
    // Imprime: 0
    //          1

    // Llamada con cuatro parámetros individuales
    printNumbers(10, 20, 30, 500)
    // Imprime: 10
    //          20
    //          30
    //          500

    // Definimos una matriz de enteros
    val numbers = intArrayOf(1, 2, 3)

    // Pasamos la matriz a la función usando el operador de propagación *
    printNumbers(*numbers)
    // Equivale a pasar printNumbers(1, 2, 3)
    // Imprime: 1
    //          2
    //          3

    // Podemos combinar valores individuales con una matriz desplegada
    printNumbers(10, 20, *numbers, 30, 40)
    // Equivale a pasar printNumbers(10, 20, 1, 2, 3, 30, 40)
    // Imprime: 10
    //          20
    //          1
    //          2
    //          3
    //          30
    //          40
}
