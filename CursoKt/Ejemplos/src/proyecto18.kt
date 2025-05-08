//Escribir un programa que solicite la carga de un número entre 0 y 999, y nos muestre un
//mensaje de cuántos dígitos tiene el mismo. Finalizar el programa cuando se cargue el valor
//0.

fun main(parametro: Array<String>) {
    do {
        print("Ingrese un valor comprendido entre 0 y 999:")
        val valor = readLine()!!.toInt()
        if (valor < 10)
            println("El valor ingresado tiene un dígito")
        else
            if (valor < 100)
                println("El valor ingresado tiene dos dígitos")
            else
                println("El valor ingresado tiene tres dígitos")
    } while (valor != 0)
}