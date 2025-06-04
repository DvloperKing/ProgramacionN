import kotlin.text.Regex

fun main() {
    // Pedimos al usuario que ingrese una cadena desde la consola
    println("Introduce una cadena para evaluar:")
    val entrada = readLine() ?: ""  // Leemos la entrada y si es null, usamos cadena vacía

    // Definimos una expresión regular para un número telefónico en formato 123-456-7890
    val regexTelefono = Regex("""\d{3}-\d{3}-\d{4}""")

    // Expresión regular que coincide con cadenas que contienen solo dígitos (números)
    val regexSoloNumeros = Regex("""\d+""")

    // Expresión regular que coincide con cadenas que contienen solo letras (mayúsculas o minúsculas)
    val regexLetras = Regex("""[a-zA-Z]+""")

    // Usamos una expresión 'when' para comparar la cadena de entrada contra los patrones
    when {
        regexTelefono.matches(entrada) ->
            println("📞 Es un número de teléfono válido.") // Si coincide con teléfono, imprime este mensaje

        regexSoloNumeros.matches(entrada) ->
            println("🔢 Contiene solo números.")          // Si solo son números, imprime este mensaje

        regexLetras.matches(entrada) ->
            println("🔤 Contiene solo letras.")            // Si solo son letras, imprime este mensaje

        else ->
            println("❌ No coincide con ningún patrón.")  // Si no coincide con ninguno, imprime este mensaje
    }
}
