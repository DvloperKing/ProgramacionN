import java.time.Duration
import java.time.Instant

// Capítulo 25: Lambdas básicas
fun main() {
    // ✅ 1. Lambda con parámetros explícitos
    val suma: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println("Suma explícita: ${suma(5, 3)}")  // Resultado: 8

    // ✅ 2. Lambda con tipos inferidos
    val multiplicar = { a: Int, b: Int -> a * b }
    println("Multiplicación inferida: ${multiplicar(4, 2)}")  // Resultado: 8

    // ✅ 3. Lambda con un solo parámetro usando `it`
    val cuadrado: (Int) -> Int = { it * it }
    println("Cuadrado de 5: ${cuadrado(5)}")  // Resultado: 25

    // ✅ 4. Lambda en función dentro de una clase
    data class Usuario(val nombre: String, val apellido: String) {
        fun username(generador: (String, String) -> String): String {
            return generador(nombre, apellido)
        }
    }
    val user = Usuario("karla", "villanueva")
    val nombreUsuario = user.username { n, a -> "${n.uppercase()}_${a.uppercase()}" }
    println("Nombre de usuario generado: $nombreUsuario")  // Resultado: KARLA_VILLANUEVA

    // ✅ 5. Lambda para filtrar listas
    data class Persona(val nombre: String, val edad: Int)
    val personas = listOf(
        Persona("Ana", 20),
        Persona("Luis", 17),
        Persona("Mario", 25)
    )
    val EDAD_MINIMA = 18
    val mayoresEdad = personas.filter { it.edad >= EDAD_MINIMA }
    println("Mayores de edad: $mayoresEdad")  // Ana y Mario

    // ✅ 6. Lambda como variable
    val esMayor = { persona: Persona -> persona.edad >= EDAD_MINIMA }
    val mayores = personas.filter(esMayor)
    println("Filtrados por edad (lambda variable): $mayores")

    // ✅ 7. Lambda para benchmarking (medición de ejecución)
    val duracion = Benchmark.tiempoEjecucion {
        Thread.sleep(1000)  // Simula una operación larga
    }
    println("Código ejecutado en: $duracion")
}

// Objeto Benchmark con función de medición de tiempo usando lambda
object Benchmark {
    fun tiempoEjecucion(bloque: () -> Unit): Duration {
        val inicio = Instant.now()
        try {
            bloque()
        } finally {
            val fin = Instant.now()
            return Duration.between(inicio, fin)
        }
    }
}
