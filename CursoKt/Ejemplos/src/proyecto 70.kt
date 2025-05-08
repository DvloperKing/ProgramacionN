fun main(parametro: Array<String>) {
    presentacion()
    cargarSumar()
    finalizacion()
}

fun presentacion() {
    println("Programa que permite cargar dos valores por teclado.")
    println("Efectua la suma de los valores")
    println("Muestra el resultado de la suma")
    println("*******************************")
}

fun cargarSumar() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}

fun finalizacion() {
    println("*******************************")
    println("Gracias por utilizar este programa")
}
