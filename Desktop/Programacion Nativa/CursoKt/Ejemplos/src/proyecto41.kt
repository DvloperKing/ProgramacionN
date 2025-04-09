fun verificarClaves(clave1: String, clave2: String) {
    if (clave1 == clave2)
        println("Las claves ingresadas son iguales.")
    else
        println("Las claves ingresadas son distintas.")
}

fun main(parametro: Array<String>) {
    print("Ingrese la clave:")
    val clave1 = readLine()!!
    print("Repita la clave:")
    val clave2 = readLine()!!
    verificarClaves(clave1, clave2)
}
