// Enum para ejemplo con when
enum class Day {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

fun main() {
    // Ejemplo de if estándar
    val mensaje = "Hello!"
    if (mensaje.length == 0) {
        println("La cadena está vacía")
    } else if (mensaje.length > 5) {
        println("La cadena es corta")
    } else {
        println("La cadena es larga")
    }

    // if como expresión
    val edad = 18
    val resultado = if (edad >= 18) "Mayor de edad" else "Menor de edad"
    println("Resultado: $resultado")

    // if como expresión multilínea
    val clima = "nublado"
    val decision = if (clima == "soleado") {
        "Salir al parque"
    } else if (clima == "lluvioso") {
        "Llevar paraguas"
    } else {
        "Quedarse en casa"
    }
    println("Decisión: $decision")

    // when sin argumento (como if-else chain)
    val numero = 8
    when {
        numero == 0 -> println("Número es cero")
        numero in 1..5 -> println("Número entre 1 y 5")
        numero > 5 -> println("Número mayor que 5")
    }

    // when con argumento
    val idioma = "German"
    when (idioma) {
        "English" -> println("How are you?")
        "German" -> println("Wie geht es dir?")
        "Spanish" -> println("¿Cómo estás?")
        else -> println("Idioma no reconocido")
    }

    // when con múltiples condiciones
    val fruta = "manzana"
    when (fruta) {
        "manzana", "pera" -> println("Es una fruta dulce")
        "limón", "toronja" -> println("Es una fruta ácida")
        else -> println("No sé qué fruta es")
    }

    // when con expresiones avanzadas
    val x: Any = "Karla"
    val nombres = listOf("Juan", "Karla", "Luis")
    when (x) {
        in nombres -> println("¡Conozco ese nombre!")
        !in 1..10 -> println("No está en el rango de 1 a 10")
        is String -> println("La longitud del texto es ${(x as String).length}")
    }

    // when como expresión
    val saludo = when (idioma) {
        "English" -> "Hello!"
        "German" -> "Hallo!"
        "Spanish" -> "¡Hola!"
        else -> "Idioma no soportado"
    }
    println("Saludo: $saludo")

    // when con enum
    val diaActual = Day.Friday
    when (diaActual) {
        Day.Monday, Day.Tuesday -> println("Es inicio de semana, a trabajar")
        Day.Wednesday -> println("Mitad de semana")
        Day.Thursday -> println("Casi es viernes")
        Day.Friday -> println("¡Por fin viernes!")
        Day.Saturday, Day.Sunday -> println("Fin de semana, a descansar")
    }

    // when con enum no exhaustivo (con else)
    val otroDia = Day.Sunday
    when (otroDia) {
        Day.Monday -> println("Trabajar")
        Day.Tuesday -> println("Trabajar más")
        else -> println("Fin de semana o mitad de semana")
    }
}
