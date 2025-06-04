// Clase simple que simula logs usando println
class FooWithLogging {

    var name = "KARLA"

    // Simula un log informativo
    fun bar() {
        println("INFO: Hola $name, esto es un mensaje de información")
    }

    // Simula un log de error con excepción
    fun logException(e: Exception) {
        println("ERROR: Ocurrió un error durante el proceso - ${e.message}")
    }
}

fun main() {
    val foo = FooWithLogging()

    // Llama a la función que escribe log informativo
    foo.bar()

    // Simula una excepción y la registra
    try {
        val x = 5 / 0
    } catch (e: Exception) {
        foo.logException(e)
    }
}
