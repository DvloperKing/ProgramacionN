fun main(parametro: Array<String>) {
    calcularSueldo("juan", 10.5, 120)
    calcularSueldo(costoHora = 12.0, cantidadHoras = 40, nombre="ana")
    calcularSueldo(cantidadHoras = 90, nombre = "luis", costoHora = 7.25)
}

fun calcularSueldo(nombre: String, costoHora: Double, cantidadHoras: Int) {
    val sueldo = costoHora * cantidadHoras
    println("$nombre trabajó $cantidadHoras horas, se le paga por hora $costoHora por lo tanto le corresponde un sueldo de $sueldo")
}
