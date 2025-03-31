//Escribir un programa que lea 10 notas de alumnos y nos informe cuántos tienen notas
//mayores o iguales a 7 y cuántos menores.

fun main(parametro: Array<String>) {
    var aprobados = 0
    var reprobados = 0
    for(i in 1..10) {
        print("Ingrese nota:")
        val nota = readLine()!!.toInt()
        if (nota >= 7)
            aprobados++
        else
            reprobados++
    }
    println("Cantidad de alumnos con notas mayores o iguales a 7: $aprobados")
    println("Cantidad de alumnos con notas menores a 7: $reprobados")
}