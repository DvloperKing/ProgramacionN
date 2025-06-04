// Definimos una clase llamada Usuario con tres propiedades: una pública, una mutable y una privada
class Usuario(val nombre: String, var edad: Int, private val secreto: String)

fun main() {
    // Creamos una instancia de la clase Usuario
    val usuario = Usuario("Karla", 25, "Contraseña123")

    // Obtenemos la clase del objeto usando reflexión de Java
    val clase = usuario.javaClass

    // Mostramos un encabezado
    println("🔍 Propiedades de la clase Usuario:")

    // Recorremos todas las propiedades declaradas en la clase (incluye privadas)
    for (campo in clase.declaredFields) {
        campo.isAccessible = true // Permitimos el acceso a propiedades privadas
        // Imprimimos el nombre del campo y su valor actual en el objeto
        println("${campo.name} = ${campo.get(usuario)}")
    }
}
