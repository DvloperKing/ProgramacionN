// CAPÍTULO 16 – FUNCIONES EN KOTLIN

// 1. FUNCIÓN BÁSICA Y ABREVIADA
fun saludar(nombre: String): String = "Hola, $nombre. Soy tu asistente virtual."

// 2. FUNCIÓN CON PARÁMETRO Y RETORNO
fun calcularEdadActual(anioNacimiento: Int): Int {
    val anioActual = 2025
    return anioActual - anioNacimiento
}

// 3. FUNCIÓN GENÉRICA
fun <T> mostrarElemento(elemento: T) {
    println("Elemento: $elemento")
}

// 4. FUNCIÓN LAMBDA
val cuadrado = { x: Int -> x * x }

// 5. FUNCIONES COMO PARÁMETROS
fun ejecutarOperacion(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

// 6. FUNCIONES EN LÍNEA
inline fun mostrarMensaje(mensaje: String) {
    println("💬 $mensaje")
}

// 7. REFERENCIA A FUNCIONES
fun triple(x: Int) = x * 3

// 8. OPERADOR SOBRECARGADO
class Caja(val valores: List<Int>) {
    operator fun get(i: Int): Int = valores[i]
}

// PROGRAMA PRINCIPAL
fun main() {
    println("----- 🧠 SISTEMA DE FUNCIONES - ASISTENTE VIRTUAL -----\n")

    // Uso de función básica
    val saludo = saludar("Karla")
    mostrarMensaje(saludo)

    // Uso de función con retorno
    val edad = calcularEdadActual(2002)
    mostrarMensaje("Tienes $edad años.")

    // Uso de función genérica
    mostrarElemento("Soy versátil")
    mostrarElemento(42)

    // Uso de lambda
    val numero = 6
    println("🔢 El cuadrado de $numero es ${cuadrado(numero)}")

    // Uso de función como parámetro
    val suma = { x: Int, y: Int -> x + y }
    val resultadoSuma = ejecutarOperacion(5, 3, suma)
    mostrarMensaje("La suma es $resultadoSuma")

    // Uso de referencia a función
    val lista = listOf(1, 2, 3)
    val listaTriplicada = lista.map(::triple)
    println("🔥 Lista triplicada: $listaTriplicada")

    // Uso de clase con operador sobrecargado
    val caja = Caja(listOf(100, 200, 300))
    println("📦 Elemento en caja[1]: ${caja[1]}")
}
