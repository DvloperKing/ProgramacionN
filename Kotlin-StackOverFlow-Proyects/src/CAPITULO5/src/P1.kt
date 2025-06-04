// Tema: Bucles en Kotlin
// Este código muestra diferentes tipos de bucles y cómo usarlos en Kotlin.

fun main() {
    // 1. Repetir una acción 5 veces con repeat
    println("Ejemplo de repeat:")
    repeat(5) { i ->
        println("Esta línea se imprime 5 veces. Iteración ${i + 1}")
    }

    // 2. Bucle for sobre una lista iterable
    println("\nBucle for sobre una lista:")
    val lista = listOf("Hola", "Mundo", "!")
    for (palabra in lista) {
        print("$palabra ")
    }
    println()

    // 3. Bucle for sobre un rango de números (0 a 4)
    println("\nBucle for sobre rango:")
    for (i in 0..4) {
        print("$i ")
    }
    println()

    // 4. Bucle for con índice y elemento usando withIndex()
    println("\nBucle for con índice y elemento:")
    for ((indice, elemento) in lista.withIndex()) {
        println("$elemento está en la posición $indice")
    }

    // 5. Uso de forEach con lambda
    println("\nUso de forEach:")
    lista.forEach {
        println("Elemento: $it")
    }

    // 6. Bucle while (imprime hasta que i sea 3)
    println("\nBucle while:")
    var i = 0
    while (i < 3) {
        println("i es $i")
        i++
    }

    // 7. Bucle do-while (al menos se ejecuta una vez)
    println("\nBucle do-while:")
    var j = 5
    do {
        println("j es $j")
        j--
    } while (j > 2)

    // 8. Uso de break y continue
    println("\nUso de break y continue:")
    for (k in 1..5) {
        if (k == 3) {
            println("Salto la iteración $k")
            continue // Salta la iteración cuando k == 3
        }
        if (k == 5) {
            println("Termino el bucle en la iteración $k")
            break // Termina el bucle cuando k == 5
        }
        println("Valor de k: $k")
    }

    // 9. Iterar sobre un mapa
    println("\nIterar sobre un mapa:")
    val mapa = hashMapOf(1 to "uno", 2 to "dos", 3 to "tres")
    for ((clave, valor) in mapa) {
        println("Clave $clave tiene valor $valor")
    }

    // 10. Recursión: cálculo factorial
    println("\nRecursión: factorial de 5 es ${factorial(5)}")

    // 11. Construcciones funcionales: map y filter
    println("\nConstrucciones funcionales:")
    val numeros = listOf(1, 2, 3, 4, 5, 6)
    val pares = numeros.filter { it % 2 == 0 }
    val textoNumeros = pares.map { "Número $it" }
    textoNumeros.forEach { println(it) }
}

// Función recursiva para calcular factorial
fun factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
