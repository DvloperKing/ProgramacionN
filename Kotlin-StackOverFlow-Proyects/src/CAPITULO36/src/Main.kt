fun main() {
    // Variable no anulable: siempre debe tener un valor String
    var textoNormal: String = "¡Hola, Kotlin!"

    // Variable anulable: puede contener un String o null
    var textoNullable: String? = null

    // No se puede asignar una variable anulable a una no anulable directamente:
    // textoNormal = textoNullable // Esto da error
    // Pero sí podemos asignar la variable no anulable a una anulable:
    textoNullable = textoNormal

    // Acceso directo a propiedades de variable no anulable
    println("Longitud textoNormal: ${textoNormal.length}") // Imprime 12

    // Acceso seguro con ?. para evitar NullPointerException
    println("Longitud textoNullable: ${textoNullable?.length}") // Imprime 12 porque no es null ahora

    // Si textoNullable es null, el acceso seguro devuelve null sin error
    textoNullable = null
    println("Longitud textoNullable tras asignar null: ${textoNullable?.length}") // Imprime null

    // Uso de 'let' para ejecutar código solo si no es null, y tratar la variable como no null dentro
    textoNullable = "Kotlin es genial"
    textoNullable?.let { noNulo ->
        println("Dentro de let: '$noNulo' tiene ${noNulo.length} caracteres")
    }

    // Comprobación explícita para smart cast (casteo inteligente)
    if (textoNullable != null) {
        // Aquí el compilador sabe que textoNullable no es null
        println("Smart cast: longitud segura = ${textoNullable.length}")
    }

    // Uso del operador Elvis ?: para dar valor por defecto en caso de null
    val longitudSeguro = textoNullable?.length ?: 0
    println("Longitud con valor por defecto: $longitudSeguro")

    // Operador Elvis con excepción: lanzar error si es null
    textoNullable = null
    try {
        val textoNoNulo: String = textoNullable ?: throw IllegalArgumentException("¡No puede ser null!")
        println(textoNoNulo)
    } catch (e: IllegalArgumentException) {
        println("Excepción capturada: ${e.message}")
    }

    // Operador !!: fuerza a tratar variable nullable como no nullable
    // ¡Ojo! Si es null, lanza excepción NullPointerException
    val otraNullable: String? = null
    // println(otraNullable!!) // Si se descomenta, esta línea lanzaría excepción y detendría el programa
}
