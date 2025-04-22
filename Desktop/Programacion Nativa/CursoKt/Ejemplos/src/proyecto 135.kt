fun main(parametro: Array<String>) {
    val dados = object {
        val arreglo = IntArray(5)
        fun generar() { for(i in arreglo.indices) { arreglo[i] = ((Math.random() * 6) + 1).toInt() } }
        fun imprimir() {
            for(elemento in arreglo) { print("$elemento - ") }
            println();
        }

        fun mayor(): Int {
            var may = arreglo[0]
            for(i in arreglo.indices) {
                if (arreglo[i] > may) {
                    may = arreglo[i]
                }
            }
            return may
        }
    }

    dados.generar()
    dados.imprimir()
    print("Mayor valor:")
    println(dados.mayor())
}