fun main() {
    val ciudad: String? = null

    // Si ciudad es null, se usa el valor por defecto "Desconocida"
    val resultado = ciudad ?: "Desconocida"
    println("Ciudad: $resultado") // Imprime: Ciudad: Desconocida
}