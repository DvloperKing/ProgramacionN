// Declaramos un objeto singleton llamado SharedRegistry
object SharedRegistry {
    // Mapa privado para almacenar pares clave-valor
    private val registry = mutableMapOf<String, Any>()

    // Función para registrar un par clave-valor en el registro
    fun register(key: String, thing: Any) {
        // Guardamos o actualizamos el valor asociado a la clave
        registry[key] = thing
        // Imprimimos un mensaje indicando que se registró el dato
        println("Registrado: $key -> $thing")
    }

    // Función para obtener un valor por su clave
    fun get(key: String): Any? {
        // Retornamos el valor asociado a la clave, o null si no existe
        return registry[key]
    }

    // Función para imprimir todo el contenido del registro
    fun printAll() {
        println("Contenido del registro:")
        // Recorremos cada par clave-valor en el mapa
        registry.forEach { (key, value) ->
            // Imprimimos la clave y su valor
            println("$key -> $value")
        }
    }
}

fun main() {
    // Registramos pares clave-valor usando el singleton
    SharedRegistry.register("a", "apple")
    SharedRegistry.register("b", "boy")
    SharedRegistry.register("c", "cat")
    SharedRegistry.register("d", "dog")

    // Obtenemos el valor registrado con la clave "b"
    val value = SharedRegistry.get("b")
    // Imprimimos el valor obtenido
    println("Obtenido por clave 'b': $value")

    // Imprimimos todos los pares clave-valor registrados
    SharedRegistry.printAll()
}
