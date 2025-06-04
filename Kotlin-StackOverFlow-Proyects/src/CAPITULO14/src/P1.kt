/**
 * Capítulo 14: Excepciones en Kotlin
 *
 * Este programa muestra cómo manejar excepciones usando:
 * 1. Bloques try-catch-finally
 * 2. Captura de múltiples tipos de excepciones
 * 3. Uso de try como expresión que retorna valor
 * 4. Lectura de archivos sin necesidad de capturar IOException (excepciones no comprobadas)
 *
 * También se incluyen clases de excepción personalizadas para simular diferentes escenarios de error.
 */

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    println("== Ejemplo 1: try-catch-finally básico ==")
    try {
        // Ejecuta una función que lanza una excepción personalizada
        doSomething()
    } catch (e: MyException) {
        // Captura y maneja la excepción
        println("Capturada MyException: ${e.message}")
    } finally {
        // Siempre se ejecuta, haya excepción o no
        println("Bloque finally ejecutado")
    }

    println("\n== Ejemplo 2: Múltiples bloques catch ==")
    try {
        // Simula una función que puede lanzar diferentes tipos de excepción
        doSomethingElse()
    } catch (e: FileSystemException) {
        println("Capturada FileSystemException: ${e.message}")
    } catch (e: NetworkException) {
        println("Capturada NetworkException: ${e.message}")
    } catch (e: MemoryException) {
        println("Capturada MemoryException: ${e.message}")
    } finally {
        // Limpieza de recursos
        println("Finalizando con cleanup()")
        cleanup()
    }

    println("\n== Ejemplo 3: try como expresión con valor de retorno ==")
    val s: String? = try {
        // Devuelve el resultado de una función que puede lanzar una excepción
        getString()
    } catch (e: Exception) {
        // Si falla, se devuelve null
        println("Error obteniendo string: ${e.message}")
        null
    }
    println("Valor obtenido: $s")

    println("\n== Ejemplo 4: Excepciones no comprobadas (sin catch obligatorio) ==")
    // Kotlin no obliga a capturar IOException
    val contenido = fileToString("archivo_ejemplo.txt")
    println("Contenido del archivo (si existe):\n$contenido")
}

// =====================
// Funciones auxiliares
// =====================

fun doSomething() {
    println("Ejecutando doSomething()...")
    // Lanza excepción personalizada
    throw MyException("Algo salió mal en doSomething")
}

fun doSomethingElse() {
    println("Ejecutando doSomethingElse()...")
    // Simulamos una de varias excepciones posibles
    throw NetworkException("Error de red simulado")
}

fun getString(): String {
    println("Simulando obtención de cadena")
    // Randommente lanza una excepción o retorna texto
    if ((0..1).random() == 1) throw Exception("Falla aleatoria")
    return "Cadena válida"
}

fun cleanup() {
    // Función que representa limpieza de recursos
    println("Limpiando recursos...")
}

fun fileToString(filePath: String): String {
    // Lee contenido de archivo sin necesidad de capturar IOException (aunque aquí lo hacemos opcionalmente)
    val path = Paths.get(filePath)
    return try {
        val fileContent = Files.readAllBytes(path)
        String(fileContent)
    } catch (e: IOException) {
        "No se pudo leer el archivo: ${e.message}"
    }
}

// =====================
// Clases de excepción personalizadas
// =====================

class MyException(message: String) : Exception(message)
class FileSystemException(message: String) : Exception(message)
class NetworkException(message: String) : Exception(message)
class MemoryException(message: String) : Exception(message)
