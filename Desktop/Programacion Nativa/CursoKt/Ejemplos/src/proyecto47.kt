// Función que retorna la superficie de un rectángulo.
fun superficieRectangulo(l1: Int, l2: Int): Int {
    return l1 * l2
}

fun main(parametro: Array<String>) {
    print("Ingrese lado 1:")
    val a = readLine()!!.toInt()
    print("Ingrese lado 2:")
    val b = readLine()!!.toInt()
    println("Superficie del rectángulo: ${superficieRectangulo(a, b)}")
}
