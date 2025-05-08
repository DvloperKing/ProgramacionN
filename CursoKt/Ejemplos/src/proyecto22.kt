//Desarrollar un programa que permita la carga de 10 valores por teclado y nos muestre
//posteriormente la suma de los valores ingresados y su promedio. Este problema ya lo
//desarrollamos empleando el while, lo resolveremos empleando la estructura repetitiva for.

fun main(parametro: Array<String>) {
    var suma = 0
    for(i in 1..10) {
        print("Ingrese un valor:")
        val valor = readLine()!!.toInt()
        suma += valor
    }
    println("La suma de los valores ingresados es $suma")
    val promedio = suma / 10
    println("Su promedio es $promedio")
}