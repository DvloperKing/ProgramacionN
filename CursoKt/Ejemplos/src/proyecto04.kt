fun main(parametro: Array<String>) {
    // Este programa solicita al usuario ingresar el lado de un cuadrado,
    // calcula el perímetro del cuadrado y lo muestra por consola.

    print("Ingrese la medida del lado del cuadrado:")
    val lado = readLine()!!.toInt()   // Lee la medida del lado del cuadrado desde el teclado y la convierte a entero

    val perimetro = lado * 4   // Calcula el perímetro multiplicando el lado por 4
    println("El perímetro del cuadrado es $perimetro")   // Muestra el perímetro por consola
}
