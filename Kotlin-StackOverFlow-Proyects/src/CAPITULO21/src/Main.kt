fun main() {
    // Elementos de cadena (acceso por índice)
    val str = "Hola, Mundo!"
    println("El carácter en la posición 1 es: ${str[1]}") // imprime 'o'

    // Iterar sobre los caracteres de la cadena
    println("Iterando caracteres:")
    for (c in str) {
        print("$c ")
    }
    println()

    // Literales de cadena escapada
    val escapedString = "Hola, mundo!\nNueva línea con tabulación:\tFin de línea."
    println("Cadena escapada:")
    println(escapedString)

    // Literales de cadena cruda (raw strings) con triple comillas
    val rawString = """
        |Iterando caracteres de "abc":
        |${buildString {
        for (c in "abc") {
            append("$c ")
        }
    }}
        |Esta es una cadena cruda,
        |puede contener saltos de línea
        |y no interpreta escapes como \n o \t.
        |(Benjamin Franklin)
    """.trimMargin()
    println("Cadena cruda con trimMargin y ejemplo de iteración:")
    println(rawString)

    // Plantillas de cadena
    val i = 10
    val s = "abc"
    val templateString = "i = $i, la longitud de s es ${s.length}"
    println("Plantillas de cadena:")
    println(templateString)

    // Mostrar signo dólar literal en cadena escapada
    val literalDollarEscaped = "\\\$foo"
    println("Signo dólar escapado en cadena escapada:")
    println(literalDollarEscaped) // imprime: \$foo

    // Mostrar signo dólar literal en cadena cruda
    val literalDollarRaw = "\$foo"
    println("Signo dólar literal en cadena cruda:")
    println(literalDollarRaw) // imprime: \$foo

    // Igualdad estructural (==) y referencial (===)
    val str1 = "Hola, Mundo!"
    val str2 = "Hola, " + "Mundo!"
    println("Igualdad estructural (==): ${str1 == str2}") // true

    val rawStr1 = """
        |Hola, Mundo!
    """.trimMargin()
    val rawStr2 = """
        #Hola, Mundo!
    """.trimMargin("#")
    val rawStr3 = rawStr1

    println("Igualdad estructural rawStr1 == rawStr2: ${rawStr1 == rawStr2}") // true
    println("Igualdad referencial rawStr1 === rawStr2: ${rawStr1 === rawStr2}") // false
    println("Igualdad referencial rawStr1 === rawStr3: ${rawStr1 === rawStr3}") // true
}
