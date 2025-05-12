fun main() {
    val texto: String? = null

    // Solo intenta obtener la longitud si texto no es null
    println(texto?.length) // Imprime: null

    val mensaje: String? = "Hola"
    println(mensaje?.length) // Imprime: 4
}