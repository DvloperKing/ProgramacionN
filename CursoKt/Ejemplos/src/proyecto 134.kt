fun main(parametro: Array<String>) {
    println("El valor de Pi es ${Matematica.PI}")
    print("Un valor aleatorio entre 5 y 10: ")
    println(Matematica.aleatorio(5, 10))
}

object Matematica {
    val PI = 3.1416
    fun aleatorio(minimo: Int, maximo: Int) = ((Math.random() * (maximo + 1 - minimo)) + minimo).toInt()
}