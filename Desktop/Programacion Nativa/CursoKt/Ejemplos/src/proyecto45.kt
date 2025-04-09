// Función que retorna el promedio de tres números.
fun promedio(a: Int, b: Int, c: Int): Double {
    return (a + b + c) / 3.0
}

fun main(parametro: Array<String>) {
    val resultado = promedio(5, 7, 9)
    println("El promedio es $resultado")
}
