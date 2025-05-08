fun main() {
    var total = 0
    for(i in 1..10) {
        print("ingrese sueldo del operario:")
        val sueldo = readLine()!!.toInt()
        total += when {
            sueldo > 5000 -> { println("Sueldo alto"); sueldo }
            sueldo > 2000 -> { println("Sueldo medio"); 0 }
            else -> { println("Sueldo bajo"); 0 }
        }
    }
    println("Gastos totales en sueldos altos: $total")
}