import java.io.File

fun main() {
    // Creamos una carpeta temporal (se borra al salir del programa si se desea)
    val carpetaTemporal = createTempDir()

    // Creamos un archivo dentro de esa carpeta
    val archivo = File(carpetaTemporal, "archivo_prueba.txt")

    // Escribimos texto en el archivo
    archivo.writeText("Hola, KARLA. Esto es una prueba.")

    // Leemos y verificamos que el contenido esté correcto
    val contenido = archivo.readText()
    if (archivo.exists() && contenido.contains("KARLA")) {
        println("✅ Archivo creado exitosamente en: ${archivo.absolutePath}")
        println("Contenido del archivo: $contenido")
    } else {
        println("❌ Algo salió mal")
    }

    // Si quieres borrar el archivo y carpeta después:
    // archivo.delete()
    // carpetaTemporal.deleteRecursively()
}
