// Tema: Delegación de clase en Kotlin
// Permite que una clase implemente una interfaz delegando la implementación
// de sus métodos a otro objeto que implementa dicha interfaz.

// Definimos la interfaz Foo con un método example()
interface Foo {
    fun example()
}

// La clase Bar implementa la interfaz Foo
// y provee la implementación concreta del método example()
class Bar : Foo {
    override fun example() {
        println("Hello, world!")
    }
}

// La clase Baz implementa la interfaz Foo delegando la implementación a un objeto Foo recibido
// Así Baz no implementa el método example() por sí misma, sino que lo delega a Bar (o cualquier Foo)
class Baz(b: Foo) : Foo by b

fun main() {
    // Creamos un objeto Baz que delega a un objeto Bar
    val baz = Baz(Bar())

    // Llamamos al método example() a través de Baz
    // La llamada se delega internamente al método example() de Bar
    baz.example()  // Imprime: Hello, world!
}
