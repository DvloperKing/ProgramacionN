fun main() {
    val operacion1 = Operacion(10, 4, TipoOperacion.SUMA)
    operacion1.operar()
}

enum class TipoOperacion (val tipo: String) {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/")
}

class Operacion (val valor1: Int, val valor2: Int, val tipoOperacion: TipoOperacion) {
    fun operar() {
        var resultado: Int = 0
        when (tipoOperacion) {
            TipoOperacion.SUMA -> resultado = valor1 + valor2
            TipoOperacion.RESTA -> resultado = valor1 - valor2
            TipoOperacion.MULTIPLICACION -> resultado = valor1 * valor2
            TipoOperacion.DIVISION -> resultado = valor1 / valor2
        }
        println("$valor1 ${tipoOperacion.tipo} $valor2 es igual a $resultado")
    }
}