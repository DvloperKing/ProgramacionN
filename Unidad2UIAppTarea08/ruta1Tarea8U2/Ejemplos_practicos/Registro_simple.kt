class Estudiante(val nombre: String, val calificaciones: List<Int>) {
    fun promedio(): Double = calificaciones.average()
    fun estaAprobado(): Boolean = promedio() >= 70
}

fun main() {
    val alumno = Estudiante("Ana", listOf(80, 90, 100))
    println("Promedio: ${alumno.promedio()}") // 90.0
    println(if (alumno.estaAprobado()) "Aprobado" else "Reprobado")
}