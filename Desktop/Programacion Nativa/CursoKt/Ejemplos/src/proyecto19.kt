//Escribir un programa que solicite la carga de números por teclado, obtener su promedio.
//Finalizar la carga de valores cuando se cargue el valor 0.

fun main(parametro: Array<String>) {
    var cant = 0
    var suma = 0
    do {
        print("Ingrese un valor (0 para finalizar):")
        val valor = readLine()!!.toInt()
        if (valor != 0) {
            suma += valor
            cant++
        }
    } while (valor !=0)
    if (cant != 0) {
        val promedio = suma / cant
        print("El promedio de los valores ingresados es: $promedio")
    } else
        print("No se ingresaron valores.")
}