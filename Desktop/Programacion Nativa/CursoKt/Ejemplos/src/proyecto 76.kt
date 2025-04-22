fun main() {
    print("Ingrese el valor del lado de un cuadrado:")
    val la = readLine()!!.toInt()
    println("Quiere calcular el perimetro o el area [ingresar texto: perimetro/area]")
    var respuesta = readLine()!!
    when (respuesta){
        "perimetro" -> mostrarPerimetro(la)
        "area" -> mostrarSuperficie(la)
    }
}
fun mostrarPerimetro(lado: Int) {
    val perimetro = lado *4
    println("El perímetro es $perimetro")
}

fun mostrarSuperficie(lado: Int) {
    val superficie = lado * lado
    println("el area es $superficie")
}
