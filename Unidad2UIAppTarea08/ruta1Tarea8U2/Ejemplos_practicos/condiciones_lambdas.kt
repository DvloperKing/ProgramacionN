class Producto(val nombre: String, val precio: Double) {
    fun aplicarDescuento(descuento: (Double) -> Double): Double {
        return descuento(precio)
    }
}

fun main() {
    val prod = Producto("Laptop", 1000.0)

    // Lambda que aplica un 10% de descuento
    val descuento = prod.aplicarDescuento { it * 0.90 }

    println("Precio con descuento: $descuento") // 900.0
}