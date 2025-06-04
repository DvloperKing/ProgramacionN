// Tema: Genéricos en Kotlin - Parámetros, límites, covarianza, contravarianza y proyecciones

// Clase genérica simple con propiedad pública
class Box<T>(var content: T)

// Clase genérica con límite superior (no anulable)
class NonNullableBox<T : Any>(var content: T)

// Clase con parámetro de tipo contravariante (in T)
class Consumer<in T> {
    fun consume(t: T) {
        println("Consumiendo: $t")
    }
}

// Clase con parámetro de tipo covariante (out T)
class Producer<out T>(private val content: T) {
    fun produce(): T = content
}

fun main() {
    // Uso básico de genéricos
    val intBox = Box(123)
    println("Box con Int: ${intBox.content}")

    val stringBox = Box("Hola genéricos")
    println("Box con String: ${stringBox.content}")

    // Uso de límite superior: T no puede ser null aquí
    val nonNullableBox = NonNullableBox("No nullable string")
    println("NonNullableBox: ${nonNullableBox.content}")

    // Covarianza - solo salida (out)
    val producer: Producer<String> = Producer("Hola Producer")
    val produceResult: String = producer.produce()
    println("Producer produce: $produceResult")

    // Contravarianza - solo entrada (in)
    val consumer: Consumer<CharSequence> = Consumer()
    consumer.consume("Hola Consumer") // String es subclase de CharSequence, OK

    // Varianza de sitio de declaración - asignaciones válidas e inválidas
    val stringConsumer: Consumer<String> = consumer // OK, Consumer<in T> permite esto
    // val anyConsumer: Consumer<Any> = consumer // ERROR, no se puede asignar Consumer<CharSequence> a Consumer<Any>

    // Varianza de sitio de uso - out-proyección (covarianza)
    val takeList: MutableList<out CharSequence> = mutableListOf("Kotlin", "Java")
    val first: CharSequence = takeList[0] // OK, puede leer valores
    println("takeList primer elemento: $first")
    // takeList.add("Nuevo") // ERROR, no se puede añadir porque el tipo exacto no está definido

    // Varianza de sitio de uso - in-proyección (contravarianza)
    val putList: MutableList<in String> = mutableListOf<Any>("algo")
    putList.add("Nuevo String") // OK, se puede añadir String
    val anyValue: Any? = putList[0] // El tipo de lectura es Any? porque el límite superior no está definido
    println("putList primer elemento: $anyValue")

    // Proyección con estrella
    val starList: MutableList<*> = mutableListOf("uno", "dos", 3)
    val starFirst: Any? = starList[0] // El tipo es Any?
    println("starList primer elemento: $starFirst")
    // starList.add("algo") // ERROR, no se puede añadir nada (excepto null)
}
