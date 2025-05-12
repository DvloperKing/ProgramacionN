// Clase base (superclase)
open class Animal(val nombre: String) {
    open fun hacerSonido() {
        println("$nombre hace un sonido.")
    }
}

// Subclase que hereda de Animal
class Gato(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: Miau!")
    }
}

fun main() {
    val miGato = Gato("Pelusa")
    miGato.hacerSonido() // Pelusa dice: Miau!
}