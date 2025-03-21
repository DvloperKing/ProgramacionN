fun main(args: Array<String>) {
    // Este programa pide al usuario ingresar el precio de un producto y la cantidad que va a llevar.
    // Luego calcula el total a pagar y lo muestra por consola.

    print("Ingrese el precio del producto:")
    val precio = readLine()!!.toDouble()   // Lee el precio del producto

    print("Ingrese la cantidad de productos:")
    val cantidad = readLine()!!.toInt()   // Lee la cantidad de productos

    val total = precio * cantidad   // Calcula el total a pagar
    println("El total a pagar es $total")   // Muestra el total
}
