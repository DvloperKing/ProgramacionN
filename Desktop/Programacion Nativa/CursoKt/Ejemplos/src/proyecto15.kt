//Mostrar números desde 1 hasta un valor ingresado.
fun main(parametro: Array<String>) {
    print("Ingrese un valor:")
    val valor = readLine()!!.toInt()
    var x = 1
    while (x <= valor) {
        println(x)
        x = x + 1
    }
}