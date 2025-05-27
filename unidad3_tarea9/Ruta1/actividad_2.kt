// Actividad 2: Crear una lista de objetos
// Creamos una lista inmutable que contiene varias instancias de la clase Amphibian.

/**
 * Lista de anfibios
 *
 * Se utiliza `listOf()` para crear una lista **inmutable** de objetos `Amphibian`.
 * Cada elemento representa una especie de anfibio con su nombre, tipo taxonómico y descripción.
 */
val amphibians = listOf(
    Amphibian("Sapo", "Anuro", "Animal que salta y croa"),
    Amphibian("Tritón", "Caudado", "Amphibio con cola")
)
