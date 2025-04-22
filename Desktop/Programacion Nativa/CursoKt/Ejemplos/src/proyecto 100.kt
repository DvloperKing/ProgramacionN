fun main() {
    val arreglo = IntArray(10)
    for(i in 0..arreglo.size-1) {
        print("Ingrese elemento:")
        arreglo[i] = readln().toInt()
    }
    var ordenado = true
    for(i in 0..arreglo.size-2) {
        if (arreglo[i + 1] < arreglo[i]) {
            ordenado = false
        }
    }

    if (ordenado) { print("Los elementos están ordenados de menor a mayor") }
    else { print("Los elementos no están ordenados de menor a mayor") }
}