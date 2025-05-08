fun main() {
    var persona1 = Persona("Juan", 22)
    var persona2 = Persona("Ana", 59)
    println(persona1)
    println(persona2)
}

data class persona2(var nombre: String, var edad: Int) {
    override fun toString(): String { return "$nombre, $edad" }
}