// Función que retorna el perímetro de un cuadrado.
fun perimetroCuadrado(lado: Int): Int {
    return lado * 4
}

fun main(parametro: Array<String>) {
    print("Ingrese el lado del cuadrado:")
    val lado = readLine()!!.toInt()
    println("El perímetro del cuadrado es ${perimetroCuadrado(lado)}")
}
