// Función que retorna la cantidad de caracteres de un String.
fun contarCaracteres(texto: String): Int = texto.length

fun main(parametro: Array<String>) {
    val nombre1 = readLine()!!
    val nombre2 = readLine()!!
    println("Más largo: ${if (contarCaracteres(nombre1) > contarCaracteres(nombre2)) nombre1 else nombre2}")
}
