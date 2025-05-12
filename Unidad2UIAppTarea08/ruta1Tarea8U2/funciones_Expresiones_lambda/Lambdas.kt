fun main() {
    val lista = listOf(1, 2, 3, 4)

    // Lambda que multiplica cada elemento por 2
    val resultado = lista.map { it * 2 }

    println(resultado) // [2, 4, 6, 8]
}