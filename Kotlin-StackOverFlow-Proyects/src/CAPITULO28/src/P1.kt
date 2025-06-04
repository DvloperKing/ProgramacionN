
// -----------------------------
// Capítulo 28: Modificadores de visibilidad
// -----------------------------

// Modificador público: accesible desde cualquier parte del proyecto
public val publicName = "Soy público"

// Modificador privado: accesible solo dentro del archivo donde se declara
private val privateName = "Soy privado"

// Modificador interno: accesible dentro del mismo módulo (proyecto)
internal val internalName = "Soy interno"

// Clase padre para demostrar el modificador protegido
open class Parent {
    // Modificador protegido: accesible solo dentro de esta clase y sus subclases
    protected val protectedName = "Soy protegido"

    // Función pública para imprimir la propiedad protegida dentro de la clase padre
    fun printProtected() {
        println("Desde Parent: $protectedName")
    }
}

// Clase hija que hereda de Parent para acceder a la propiedad protegida
class Child : Parent() {
    fun accessProtected() {
        println("Desde Child: $protectedName")
    }
}

fun main() {
    // Acceso a la variable pública
    println("Public: $publicName")

    // Acceso a la variable privada NO es posible aquí porque está en el mismo archivo, pero
    // normalmente privada es para visibilidad limitada (aquí sí se puede porque estamos en el mismo archivo)
    println("Private: $privateName")

    // Acceso a la variable interna (visible dentro del mismo módulo)
    println("Internal: $internalName")

    // Uso de clase Parent
    val parent = Parent()
    parent.printProtected()  // Imprime propiedad protegida desde método público de la clase Parent

    // Uso de clase Child que accede a propiedad protegida heredada
    val child = Child()
    child.accessProtected()  // Imprime propiedad protegida desde clase hija
}
