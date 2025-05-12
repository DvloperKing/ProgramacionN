fun main() {
    val correo: String? = null

    try {
        // Esto lanzará NullPointerException porque correo es null
        println(correo!!.length)
    } catch (e: NullPointerException) {
        println("Error: valor inesperado null")
    }

    val otroCorreo: String? = "user@email.com"
    println(otroCorreo!!.length) // Imprime: 15
}