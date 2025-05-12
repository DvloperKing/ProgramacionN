class Calculadora(val numero1: Int, val numero2: Int) {

    // Método que suma los dos números
    fun sumar(): Int {
        return numero1 + numero2
    }

    // Propiedad calculada
    val producto: Int
        get() = numero1 * numero2
}

fun main() {
    val calc = Calculadora(4, 5)
    println("Suma: ${calc.sumar()}")         // Suma: 9
    println("Producto: ${calc.producto}")    // Producto: 20
}