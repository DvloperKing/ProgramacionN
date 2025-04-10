package Cap1

//Hola mundo usando un objeto compañero

class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            App().run()
        }
    }

    fun run() {
        println("Hello World from Programa3")
    }
}