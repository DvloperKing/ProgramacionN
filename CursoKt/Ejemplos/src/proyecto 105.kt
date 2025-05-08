fun main() {
    val arreglo = IntArray(5)
    cargar(arreglo)
    imprimir(arreglo)
}

fun cargar(arreglo: IntArray) {
    for(i in arreglo.indices) {
        print("Ingrese elemento:")
        arreglo[i] = readln().toInt()
    }
}
fun imprimir(arreglo: IntArray) { for(elemento in arreglo) { println(elemento) } }
