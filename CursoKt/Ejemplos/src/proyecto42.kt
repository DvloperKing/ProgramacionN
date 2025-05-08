// Función que muestra el cuadrado de un número ingresado.
fun mostrarCuadrado(valor: Int) {
    println("El cuadrado de $valor es ${valor * valor}")
}

fun main(parametro: Array<String>) {
    print("Ingrese un número:")
    val numero = readLine()!!.toInt()
    mostrarCuadrado(numero)
}
