// Enum con propiedades (color RGB)
enum class Color(val rgb: Int) {
    RED(0xFF0000),   // Rojo, con valor RGB
    GREEN(0x00FF00), // Verde
    BLUE(0x0000FF);  // Azul (nota el punto y coma final porque luego hay miembros)

    // Función que devuelve el código hexadecimal del color
    fun colorString(): String = "#%06X".format(rgb)
}

fun main() {
    // Accedemos directamente a una constante del enum
    val favorito = Color.GREEN

    // Imprimimos su nombre, valor RGB y posición
    println("🎨 Color favorito: ${favorito.name}")       // GREEN
    println("🔢 Código RGB: ${favorito.rgb}")           // 65280
    println("📌 Posición ordinal: ${favorito.ordinal}") // 1

    // Convertimos enum a cadena hexadecimal
    println("🌐 Hexadecimal: ${favorito.colorString()}") // #00FF00

    // Listamos todas las constantes del enum con values()
    println("\n📋 Colores disponibles:")
    for (color in Color.values()) {
        println("- ${color.name} (${color.colorString()})")
    }

    // valueOf() convierte una cadena en una constante del enum
    val fromName = Color.valueOf("BLUE")
    println("\n🔎 Buscando 'BLUE': ${fromName.name} con RGB ${fromName.colorString()}")

    // valueOf() lanza error si no encuentra el nombre
    try {
        val invalid = Color.valueOf("YELLOW")
    } catch (e: IllegalArgumentException) {
        println("⚠️ Error: ${e.message}") // No enum constant...
    }

    // Uso de enum mutable (singleton con propiedades modificables)
    println("\n🌍 Planeta actual:")
    println(Planet.MARS) // MARS[population=0]

    Planet.MARS.population = 3 // Cambiamos la población de MARS
    println("👽 Después de colonizar Marte:")
    println(Planet.MARS) // MARS[population=3]
}

enum class Planet(var population: Long = 0) {  // <-- CAMBIADO a Long
    EARTH(7_000_000_000),
    MARS(); // Valor por defecto: 0L

    override fun toString(): String = "$name[population=$population]"
}
