fun main() {
    println("Inicio de la simulación")

    // Simula una tarea que tarda 1 segundo pero bloqueante (sin coroutines)
    Thread {
        Thread.sleep(1000L)
        println("Tarea terminada: ¡World!")
    }.start()

    println("Esto se imprime mientras la tarea está esperando")

    // Simulación en main thread
    repeat(4) { i ->
        Thread.sleep(500L)
        println("Simulación en main: paso ${i + 1}")
    }

    println("Fin de la simulación")
}
