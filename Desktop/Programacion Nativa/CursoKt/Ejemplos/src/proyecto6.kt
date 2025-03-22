fun main(parametro: Array<String>) {
    // Este programa solicita al usuario el ingreso del sueldo de una persona.
    // Si el sueldo supera los $3000, muestra un mensaje indicando que debe pagar impuestos.

    print("Ingrese el sueldo del empleado:")
    val sueldo = readLine()!!.toDouble()   // Lee el sueldo ingresado por el usuario y lo convierte a Double

    if (sueldo > 3000)   // Condición: si el sueldo es mayor a 3000
        println("Debe pagar impuestos")   // Muestra el mensaje si la condición es verdadera
}
