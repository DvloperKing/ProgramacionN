
//Desarrollar un programa que permita la carga de 10 valores por teclado y nos muestre
//posteriormente la suma de los valores ingresados y su promedio.

fun main(parametro: Array<String>) {
    var x = 1
    var suma = 0
    while (x <= 10) {
        print("Ingrese un valor:")
        val valor=readLine()!!.toInt()
        suma = suma + valor
        x = x + 1
    }
    println("La suma de los 10 valores ingresados es $suma")
    val promedio = suma / 10
    println("El promedio es $promedio")
}