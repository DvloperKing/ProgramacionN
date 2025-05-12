fun main() {
    val productos = listOf(
        Producto("Mouse", 20.0),
        Producto("Teclado", 50.0),
        Producto("Monitor", 150.0)
    )

    // Filtrar los que cuestan más de 30
    val caros = productos.filter { it.precio > 30 }

    caros.forEach { println(it.nombre) } // Teclado, Monitor
}