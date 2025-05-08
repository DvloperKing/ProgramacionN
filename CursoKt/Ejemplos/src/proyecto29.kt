//Ingresar los sueldos de 10 empleados por teclado. Mostrar un mensaje según el valor del
//sueldo:
fun main(parametro: Array<String>) {
    var total = 0
    for (i in 1..10) {
        print("Ingrese sueldo del operario: ")
        val sueldo = readLine()!!.toInt()
        total += when {
            sueldo > 5000 -> {
                println("Sueldo alto")
                sueldo
            }
            sueldo > 2000 -> {
                println("Sueldo medio")
                0
            }
            else -> {
                println("Sueldo bajo")
                0  // Aquí aseguramos que devuelve un valor
            }
        }
    }
    println("Gastos totales en sueldos altos: $total")
}
