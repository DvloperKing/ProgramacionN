fun main() {
    val carta1 = Carta(TipoCarta.TREBOL, 4)
    carta1.imprimir()
}

enum class TipoCarta{
    DIAMANTE,
    TREBOL,
    CORAZON,
    PICA
}

class Carta(val tipo: TipoCarta, val valor: Int) {
    fun imprimir() { println("Carta: $tipo y su valor es $valor") }
}