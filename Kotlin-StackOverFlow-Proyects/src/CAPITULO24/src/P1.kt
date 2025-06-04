fun main() {
    val someString = "123"  // Este valor puede cambiar a algo inválido como "abc" para probar la excepción

    // 🔹 Tema: try como expresión
    // En Kotlin, try puede devolver un valor, lo cual no es posible en Java.
    // Esta línea intenta convertir una cadena en entero.
    // Si falla (por ejemplo, si la cadena no es numérica), se devuelve el valor 42 como fallback.
    val i = try {
        Integer.parseInt(someString)  // Intenta convertir la cadena
    } catch (ex: Exception) {
        42  // Si falla, retorna 42 en lugar de lanzar la excepción
    }

    // Imprime el resultado de la conversión o el valor alternativo
    println("El valor de i es: $i")
}
