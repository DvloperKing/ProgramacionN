class Usuario(val nombre: String, val edad: Int)

fun main() {
    val user = Usuario("Laura", 28)
    println("Nombre: ${user.nombre}, Edad: ${user.edad}")
}