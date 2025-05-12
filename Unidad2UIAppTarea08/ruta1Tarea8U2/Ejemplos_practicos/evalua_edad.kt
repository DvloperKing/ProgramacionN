fun evaluarEdad(edad: Int): String {
    return when {
        edad < 0 -> "Edad inválida"
        edad in 0..12 -> "Eres un niño"
        edad in 13..17 -> "Eres un adolescente"
        else -> "Eres un adulto"
    }
}

fun main() {
    println(evaluarEdad(15)) // Eres un adolescente
}