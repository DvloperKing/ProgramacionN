// Función que multiplica dos valores y muestra el resultado.
fun producto(v1: Int, v2: Int) {
    println("El producto es ${v1 * v2}")
}

fun main(parametro: Array<String>) {
    print("Ingrese primer número:")
    val a = readLine()!!.toInt()
    print("Ingrese segundo número:")
    val b = readLine()!!.toInt()
    producto(a, b)
}
