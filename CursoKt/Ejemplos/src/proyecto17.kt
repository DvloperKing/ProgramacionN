//Una planta que fabrica perfiles de hierro posee un lote de n piezas.
//Confeccionar un programa que pida ingresar por teclado la cantidad de piezas a procesar y
//luego ingrese la longitud de cada perfil; sabiendo que la pieza cuya longitud esté
//comprendida en el rango de 1.20 y 1.30 son aptas. Imprimir por pantalla la cantidad de
//piezas aptas que hay en el lote
fun main(parametro: Array<String>) {
    print("Cuantas piezas procesará:")
    val n = readLine()!!.toInt()
    var x = 1
    var cantidad = 0
    while (x <= n) {
        print("Ingrese la medida de la pieza:")
        val largo = readLine()!!.toDouble()
        if (largo >= 1.20 && largo <= 1.30)
            cantidad = cantidad +1
        x = x + 1;
    }
    print("La cantidad de piezas aptas son: $cantidad")
}