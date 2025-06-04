// Tema: Uso de rangos (Ranges) en Kotlin - Creación, Iteración, Paso, Inversión y Exclusión

fun main() {
    // 1. Rango básico con operador ".." (rangeTo)
    // Itera de 1 a 4 incluyendo ambos extremos
    println("Rango básico 1..4:")
    for (i in 1..4) {
        print(i) // Imprime: 1234
    }
    println()

    // 2. Rango vacío (4..1) porque el inicio es mayor que el fin
    println("Rango vacío 4..1:")
    for (i in 4..1) {
        print(i) // No imprime nada
    }
    println()

    // 3. Rango en orden inverso usando downTo()
    println("Rango inverso con downTo (4 downTo 1):")
    for (i in 4 downTo 1) {
        print(i) // Imprime: 4321
    }
    println()

    // 4. Rango con paso arbitrario usando step()
    println("Rango con paso 2 de 1 a 4 (1..4 step 2):")
    for (i in 1..4 step 2) {
        print(i) // Imprime: 13
    }
    println()

    println("Rango inverso con paso 2 (4 downTo 1 step 2):")
    for (i in 4 downTo 1 step 2) {
        print(i) // Imprime: 42
    }
    println()

    // 5. Rango que excluye el último elemento usando until()
    println("Rango con until (1 until 10):")
    for (i in 1 until 10) {
        print("$i ") // Imprime: 1 2 3 4 5 6 7 8 9 
    }
    println()
}
