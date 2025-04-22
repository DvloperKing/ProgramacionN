fun main(parametro: Array<String>) {
    val dado1 = dado2()
    dado1.tirar()
    dado1.imprimir()
}

class dado2{
    private var valor: Int = 1
    fun tirar() { valor = ((Math.random() * 6) + 1).toInt() }

    fun imprimir() {
        separador()
        println("Valor del dado: $valor")
        separador()
    }
}

private fun separador() = println("**************************************")
