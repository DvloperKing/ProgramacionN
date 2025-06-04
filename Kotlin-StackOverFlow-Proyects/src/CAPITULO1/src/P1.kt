// Tema: Programa básico "Hola Mundo" y ejemplos de main en Kotlin

@file:JvmName("MyApp") // Cambia el nombre de la clase generada a MyApp
package my.program

// Función main de nivel superior que imprime "Hello, world!"
fun main(args: Array<String>) {
    println("Hello, world!")

    // Leer dos números desde entrada estándar y mostrar cuál es mayor
    println("Enter two numbers separated by space:")
    val input = readLine()
    if (input != null) {
        val (a, b) = input.split(' ')
        println("Max number is: ${maxNum(a.toInt(), b.toInt())}")
    } else {
        println("No input provided.")
    }

    // Ejecutar otros estilos de main
    AppObject.main(args)
    AppCompanion.main(args)
    AppInstance.main(args)
}

// Función para determinar cuál número es mayor
fun maxNum(a: Int, b: Int): Int {
    return if (a > b) {
        println("The value of a is $a")
        a
    } else {
        println("The value of b is $b")
        b
    }
}

// Objeto con función main estática
object AppObject {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello from object AppObject!")
    }
}

// Clase con companion object que tiene función main estática
class AppCompanion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello from companion object AppCompanion!")
        }
    }
}

// Clase con companion object y un método de instancia que se llama desde main
class AppInstance {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AppInstance().run()
        }
    }

    fun run() {
        println("Hello from instance method run() in AppInstance!")
    }
}
