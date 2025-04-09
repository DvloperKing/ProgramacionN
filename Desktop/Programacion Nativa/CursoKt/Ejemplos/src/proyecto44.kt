// Función que determina el menor de tres números.
fun menorDeTres(a: Int, b: Int, c: Int) {
    val menor = if (a < b && a < c) a else if (b < c) b else c
    println("El menor valor es: $menor")
}

fun main(parametro: Array<String>) {
    repeat(2) {
        print("Ingrese el primer valor:")
        val x = readLine()!!.toInt()
        print("Ingrese el segundo valor:")
        val y = readLine()!!.toInt()
        print("Ingrese el tercer valor:")
        val z = readLine()!!.toInt()
        menorDeTres(x, y, z)
    }
}
