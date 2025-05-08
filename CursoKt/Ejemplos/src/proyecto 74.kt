fun main() {
    mmostrarMensaje("El programa calcula la suma de dos valores ingresados por teclado.")
    cargarSumar2()
    mmostrarMensaje("Gracias por utilizar este programa")
}

fun mmostrarMensaje(mensaje: String) {
    println("*************************************************")
    println(mensaje)
    println("*************************************************")
}

fun cargarSumar2() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}
