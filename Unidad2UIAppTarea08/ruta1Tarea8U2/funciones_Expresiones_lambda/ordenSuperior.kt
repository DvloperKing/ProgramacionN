// Función que recibe otra función como parámetro
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

fun main() {
    val suma = operar(5, 3) { x, y -> x + y }
    val multiplicacion = operar(5, 3) { x, y -> x * y }

    println("Suma: $suma")             // Suma: 8
    println("Multiplicación: $multiplicacion") // Multiplicación: 15
}