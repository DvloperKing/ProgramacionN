//Escribir un programa que lea n números enteros y calcule la cantidad de valores pares
//ingresados.
//Este tipo de problemas también se puede resolver empleando la estructura repetitiva for ya
//que cuando expresamos el rango podemos disponer un nombre de variable.

fun main(parametros: Array<String>) {
    var cant = 0
    print("Cuantos valores ingresará para analizar:")
    val cantidad = readLine()!!.toInt()
    for(i in 1..cantidad) {
        print("Ingrese valor:")
        val valor = readLine()!!.toInt()
        if (valor % 2 ==0)
            cant++
    }
    println("Cantidad de pares: $cant")
}