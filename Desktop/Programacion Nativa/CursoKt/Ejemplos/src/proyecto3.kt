fun main(argumento: Array<String>) {
    // Este programa solicita al usuario ingresar dos números enteros por teclado,
    // calcula la suma y el producto de esos números, y muestra los resultados.

    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt()   // Lee el primer valor desde el teclado y lo convierte a entero

    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt()   // Lee el segundo valor desde el teclado y lo convierte a entero

    val suma = valor1 + valor2   // Calcula la suma de los dos valores ingresados
    println("La suma de $valor1 y $valor2 es $suma")   // Muestra la suma por consola

    val producto = valor1 * valor2   // Calcula el producto de los dos valores ingresados
    println("El producto de $valor1 y $valor2 es $producto")   // Muestra el producto por consola
}
