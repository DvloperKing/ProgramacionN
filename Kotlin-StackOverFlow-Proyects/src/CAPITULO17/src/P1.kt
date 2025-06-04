// CAPÍTULO 17 – FUNDAMENTOS DE KOTLIN

// 1. FUNCIÓN BÁSICA CON UNIDAD (tipo Unit implícito)
fun printHello(name: String?) {
    if (name != null)
        println("👋 ¡Hola, $name! Bienvenido al centro de entrenamiento.")
}

// 2. FUNCIÓN DE EXPRESIÓN SIMPLE
fun doble(x: Int) = x * 2  // El tipo Int se infiere automáticamente

// 3. INTERPOLACIÓN DE CADENAS
fun mostrarContador(i: Int) {
    val mensaje = "🔢 Contador = $i"
    println(mensaje)
}

// 4. EJEMPLO DE VARIABLES val Y var
fun ejemploVariables() {
    val inmutable = "Soy constante"
    var mutable = "Puedo cambiar"
    println("✅ val: $inmutable")
    println("🔄 var antes: $mutable")
    mutable = "He cambiado"
    println("🔄 var después: $mutable")
}

// 5. SISTEMA DE TIPOS NULLABLES
fun pruebaNulos() {
    var texto: String = "No puedo ser null"
    // texto = null // ❌ Error de compilación

    var textoNullable: String? = "Yo sí puedo ser null"
    println("Antes: $textoNullable")
    textoNullable = null
    println("Después: $textoNullable")
}

// 6. IGUALDAD DE VALOR Y REFERENCIA
fun compararObjetos() {
    val x = "Hola"
    val y = "Hola"
    val z = x

    println("==  ¿x y y tienen el mismo valor? ${x == y}")      // true
    println("=== ¿x y y son el mismo objeto? ${x === y}")      // true (por optimización de cadenas)
    println("=== ¿x y z son el mismo objeto? ${x === z}")      // true
}

// PROGRAMA PRINCIPAL
fun main() {
    println("🎓 Bienvenido al Centro de Entrenamiento Kotlin\n")

    // Saludo con función que retorna Unit
    printHello("Karla")

    // Uso de función de expresión
    println("El doble de 7 es: ${doble(7)}")

    // Interpolación de cadenas
    mostrarContador(5)

    // Variables val y var
    ejemploVariables()

    // Tipos nullable
    pruebaNulos()

    // Comparación de valores y referencias
    compararObjetos()
}
