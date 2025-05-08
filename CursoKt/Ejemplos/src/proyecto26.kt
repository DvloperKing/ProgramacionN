//Escribir un programa que pida ingresar la coordenada de un punto en el plano, es decir dos
//valores enteros x e y.
//Posteriormente imprimir en pantalla en que cuadrante se ubica dicho punto. (1º Cuadrante si
//x > 0 Y y > 0 , 2º Cuadrante: x < 0 Y y > 0, 3º Cuadrante: x < 0 Y y < 0, 4º Cuadrante: x > 0 Y
//y < 0)
//Si alguno o los dos valores son cero luego el punto se encuentra en un eje.

fun main(parametro: Array<String>) {
    print("Ingrese coordenada x del punto:")
    val x = readLine()!!.toInt()
    print("Ingrese coordenada y del punto:")
    val y = readLine()!!.toInt()
    when {
        x > 0 && y > 0 -> println("Primer cuadrate")
        x < 0 && y > 0 -> println("Segundo cuadrante")
        x < 0 && y < 0 -> println("Tercer cuadrante")
        x > 0 && y < 0 -> println("Cuarto cuadrante")
        else -> println("El punto se encuentra en un eje")
    }
}