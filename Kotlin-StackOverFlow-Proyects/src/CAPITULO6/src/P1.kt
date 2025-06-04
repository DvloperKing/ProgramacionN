fun main() {
    // Tema: Colecciones en Kotlin
    // Kotlin distingue entre colecciones inmutables (solo lectura) y mutables (se pueden modificar)

    // 1. Lista inmutable (no se puede modificar)
    val listaInmutable = listOf("Manzana", "Banana", "Cereza")
    println("Lista inmutable: $listaInmutable")

    // 2. Lista mutable (se puede agregar o eliminar elementos)
    val listaMutable = arrayListOf("Rojo", "Verde", "Azul")
    println("Lista mutable antes: $listaMutable")
    listaMutable.add("Amarillo")  // agregamos un elemento
    listaMutable.remove("Verde")  // removemos un elemento
    println("Lista mutable después: $listaMutable")

    // 3. Mapa inmutable (no se puede modificar)
    val mapaInmutable = mapOf(1 to "Uno", 2 to "Dos", 3 to "Tres")
    println("Mapa inmutable: $mapaInmutable")

    // 4. Mapa mutable (se puede modificar)
    val mapaMutable = hashMapOf(1 to "Lunes", 2 to "Martes")
    println("Mapa mutable antes: $mapaMutable")
    mapaMutable[3] = "Miércoles"  // agregamos un par clave-valor
    mapaMutable.remove(1)          // removemos un par por clave
    println("Mapa mutable después: $mapaMutable")

    // 5. Set inmutable (colección sin duplicados, no modificable)
    val setInmutable = setOf(10, 20, 30)
    println("Set inmutable: $setInmutable")

    // 6. Set mutable (se puede modificar)
    val setMutable = hashSetOf(100, 200, 300)
    println("Set mutable antes: $setMutable")
    setMutable.add(400)  // agregamos un elemento
    setMutable.remove(200)  // removemos un elemento
    println("Set mutable después: $setMutable")
}
