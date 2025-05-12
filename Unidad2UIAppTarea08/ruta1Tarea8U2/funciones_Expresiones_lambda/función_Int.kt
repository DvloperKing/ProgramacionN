// Declaración de una función como variable
val cuadrado: (Int) -> Int = { numero -> numero * numero }

fun main() {
    println(cuadrado(4)) // Imprime: 16
}