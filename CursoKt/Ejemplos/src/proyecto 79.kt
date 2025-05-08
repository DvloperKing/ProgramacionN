fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado del cuadrado:")
    val la = readLine()!!.toInt()
    val superficie = retornarSuperficie(la)
    println("La superficie del cuadrado es $superficie")
}

fun retornarSuperficie(lado: Int): Int {
    val sup = lado * lado
    return sup
}
