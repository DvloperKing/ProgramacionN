import kotlin.random.Random // Importa utilidad para generar respuestas aleatorias

// Clase principal para la encuesta
class Survey(val title: String) {
    private val questions = mutableListOf<Question>() // Lista de preguntas

    // Operador para agregar una pregunta usando +Question
    operator fun Question.unaryPlus() {
        questions += this
    }

    // Operador invoke para usar bloques tipo DSL: encuesta { ... }
    operator fun invoke(block: Survey.() -> Unit) {
        println("📝 Iniciando encuesta: $title")
        this.block() // Ejecuta el bloque de configuración
        println("\n✅ Encuesta finalizada. ¡Gracias por participar!")
    }

    // Ejecuta cada pregunta una por una
    fun run() {
        questions.forEach { it.ask() }
    }
}

// Clase para representar una pregunta de opción múltiple
class Question(val prompt: String) {
    private val options = mutableListOf<String>()     // Opciones posibles
    private var correctAnswer: Int? = null            // Índice de la respuesta correcta

    // Función para agregar una opción, marcando si es la correcta
    fun option(text: String, isCorrect: Boolean = false) {
        if (isCorrect) correctAnswer = options.size   // Guarda el índice correcto
        options += text
    }

    // Lógica que "hace" la pregunta al usuario (aquí simula la respuesta)
    fun ask() {
        println("\n❓ $prompt") // Muestra la pregunta
        options.forEachIndexed { index, opt ->
            println(" ${index + 1}. $opt") // Muestra cada opción
        }

        // Simulación de respuesta aleatoria del usuario
        val selected = Random.nextInt(options.size)
        println("👉 Simulación: el usuario seleccionó opción ${selected + 1}")

        // Verifica si fue la correcta
        if (selected == correctAnswer) {
            println("✅ ¡Correcto!")
        } else {
            println("❌ Incorrecto. La respuesta correcta era: ${correctAnswer?.plus(1)}")
        }
    }
}

// Permite envolver bloques con manejo de errores usando "Título" { ... }
operator fun String.invoke(block: () -> Unit) = try {
    println("\n🔍 $this") // Muestra el título
    block()               // Ejecuta el bloque de código
} catch (e: Exception) {
    println("⚠️ Error durante la encuesta: ${e.message}") // Si falla, imprime mensaje
}

// Función principal
fun main() {
    // Crea una encuesta usando DSL
    val encuesta = Survey("Conocimientos generales")

    // Agrega preguntas a la encuesta usando +Question y bloque invoke
    encuesta {
        +Question("¿Cuál es la capital de Francia?").apply {
            option("Madrid")
            option("París", isCorrect = true) // Esta es la opción correcta
            option("Berlín")
        }

        +Question("¿Cuánto es 5 x 3?").apply {
            option("15", isCorrect = true)
            option("10")
            option("8")
        }

        +Question("¿Qué lenguaje estamos usando?").apply {
            option("Java")
            option("Kotlin", isCorrect = true)
            option("Python")
        }
    }

    // Ejecuta la encuesta envuelta en un bloque con nombre
    "Ejecutando encuesta simulada" {
        encuesta.run()
    }
}
