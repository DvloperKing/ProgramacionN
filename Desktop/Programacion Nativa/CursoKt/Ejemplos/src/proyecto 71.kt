fun main() {
    for (i in 1..5) {
        cargarSuma()
        separacion()
    }
}

fun cargarSuma() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}

fun separacion() { println("*******************************") }