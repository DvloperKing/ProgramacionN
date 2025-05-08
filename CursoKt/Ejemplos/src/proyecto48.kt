// Compara superficies de dos rectángulos e indica cuál es mayor.
fun superficie(l1: Int, l2: Int): Int = l1 * l2

fun main(parametro: Array<String>) {
    println("Primer rectángulo:")
    val a1 = readLine()!!.toInt()
    val b1 = readLine()!!.toInt()

    println("Segundo rectángulo:")
    val a2 = readLine()!!.toInt()
    val b2 = readLine()!!.toInt()

    val sup1 = superficie(a1, b1)
    val sup2 = superficie(a2, b2)

    println("Mayor superficie: ${if (sup1 > sup2) sup1 else sup2}")
}
