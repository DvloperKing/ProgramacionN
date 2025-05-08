fun main() {
    val suma1 = Suma(10, 4)
    suma1.operar()
    suma1.imprimir()
    val resta1 = Resta(20, 5)
    resta1.operar()
    resta1.imprimir()
}

abstract class operacion(val valor1: Int, val valor2: Int) {
    protected var resultado: Int = 0
    abstract fun operar()
    fun imprimir() { println("Resultado: $resultado") }
}

class Suma(valor1: Int, valor2: Int): operacion(valor1, valor2) {
    override fun operar() { resultado = valor1 + valor2 }
}

class Resta(valor1: Int, valor2: Int): operacion(valor1, valor2) {
    override fun operar() { resultado = valor1 - valor2 }
}