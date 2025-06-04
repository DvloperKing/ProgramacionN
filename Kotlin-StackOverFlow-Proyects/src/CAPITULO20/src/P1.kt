// Clase base abierta para permitir herencia
open class Fruit(val name: String) {
    open fun showInfo() {
        println("Esta es una fruta llamada $name")
    }
}

// Clases derivadas que heredan de Fruit
class Apple : Fruit("Manzana") {
    override fun showInfo() {
        println("Esta es una manzana roja y dulce")
    }
}

class Orange : Fruit("Naranja") {
    override fun showInfo() {
        println("Esta es una naranja cítrica y jugosa")
    }
}

// Clase base con propiedad
open class BaseClass {
    val x = 10
}

// Clase derivada que hereda propiedad x y tiene un método extra
class DerivedClass : BaseClass() {
    fun foo() {
        println("x es igual a $x")
    }
}

// Clase base con métodos
open class Person {
    fun jump() {
        println("Saltando...")
    }
}

// Clase derivada con método propio y acceso al método de la base
class Ninja : Person() {
    fun sneak() {
        println("Moviéndose sigilosamente...")
    }
}

// Clase abstracta con propiedades anulables y mutables
abstract class Car {
    abstract val name: String
    open var speed: Int = 0
}

// Clase que anula propiedades, con getter y setter personalizado
class BrokenCar(override val name: String) : Car() {
    override var speed: Int
        get() = 0
        set(value) {
            throw UnsupportedOperationException("El auto está roto, no puede cambiar la velocidad")
        }
}

// Interfaz con métodos a implementar
interface Ship {
    fun sail()
    fun sink()
}

// Objeto singleton que implementa la interfaz Ship
object Titanic : Ship {
    var canSail = true

    override fun sail() {
        println("El Titanic está navegando...")
        sink()
    }

    override fun sink() {
        println("El Titanic está hundiéndose...")
        canSail = false
    }
}

// Función main para ejecutar y probar todo
fun main() {
    // Prueba clases Fruit y herencia
    val apple = Apple()
    apple.showInfo()    // Imprime: Esta es una manzana roja y dulce

    val orange = Orange()
    orange.showInfo()   // Imprime: Esta es una naranja cítrica y jugosa

    // Prueba herencia de propiedades
    val derived = DerivedClass()
    derived.foo()       // Imprime: x es igual a 10

    // Prueba herencia de métodos
    val ninja = Ninja()
    ninja.jump()        // Imprime: Saltando...
    ninja.sneak()       // Imprime: Moviéndose sigilosamente...

    // Prueba clase abstracta y anulación
    val brokenCar: Car = BrokenCar("Lada")
    println("Nombre del auto: ${brokenCar.name}")
    println("Velocidad inicial: ${brokenCar.speed}")

    try {
        brokenCar.speed = 10   // Lanzará excepción
    } catch (e: UnsupportedOperationException) {
        println("Error: ${e.message}")
    }

    // Prueba interfaz y objeto singleton
    Titanic.sail()     // Imprime: El Titanic está navegando... y luego El Titanic está hundiéndose...
    println("¿Puede navegar el Titanic? ${Titanic.canSail}")  // Imprime: false
}
