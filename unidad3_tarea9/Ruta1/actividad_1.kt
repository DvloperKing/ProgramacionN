// Actividad 1: Definir una clase de datos
// Esta clase representa el modelo de datos para un anfibio en el contexto de una aplicación educativa o biológica.

/**
 * Clase de datos Amphibian
 * 
 * Representa las propiedades básicas de un anfibio:
 * - name: Nombre común del anfibio (ej. "Sapo", "Salamandra")
 * - type: Clasificación biológica (ej. "Anuro", "Caudado")
 * - description: Descripción corta sobre características o comportamiento
 *
 * Esta clase es ideal para usar en listas, filtrado, agrupación o visualización con Jetpack Compose.
 */
data class Amphibian(
    val name: String,         // Nombre común del anfibio
    val type: String,         // Tipo taxonómico: "Anuro", "Caudado", etc.
    val description: String   // Descripción breve sobre el anfibio
)
