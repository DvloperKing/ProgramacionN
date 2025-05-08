fun main(parametro: Array<String>) {
    // Este programa define dos valores enteros inmutables (valor1 y valor2),
    // calcula su suma y su producto, y muestra ambos resultados por consola.

    val valor1: Int = 100   // Definimos el primer valor
    val valor2: Int = 400   // Definimos el segundo valor
    var resultado: Int = valor1 + valor2   // Calculamos la suma de los dos valores
    println("La suma de $valor1 + $valor2 es $resultado")   // Mostramos la suma
    resultado = valor1 * valor2   // Calculamos el producto de los dos valores
    println("El producto de $valor1 * $valor2 es $resultado")   // Mostramos el producto
}
