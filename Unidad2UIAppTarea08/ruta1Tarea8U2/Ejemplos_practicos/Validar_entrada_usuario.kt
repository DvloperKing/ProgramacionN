fun evaluarUsuario(usuario: String?): String {
    return if (usuario.isNullOrBlank()) {
        "Nombre no válido"
    } else {
        "Bienvenido, $usuario"
    }
}

fun main() {
    val entrada: String? = "Carlos" // Puedes probar con null o ""
    println(evaluarUsuario(entrada)) // Bienvenido, Carlos
}