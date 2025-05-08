fun main() {
    print("Ingrese el número de triángulos: ")
    val triangulos = readln().toInt()

    var escaleno = 0
    var isosceles = 0
    var equilatero = 0

    for (i in 1..triangulos) {
        println("\nTriángulo $i")
        print("Ingrese la longitud del lado 1: ")
        val lado1 = readln().toInt()
        print("Ingrese la longitud del lado 2: ")
        val lado2 = readln().toInt()
        print("Ingrese la longitud del lado 3: ")
        val lado3 = readln().toInt()

        when {
            lado1 == lado2 && lado2 == lado3 -> {
                println("Es un triángulo equilátero.")
                equilatero++
            }
            lado1 == lado2 || lado2 == lado3 || lado1 == lado3 -> {
                println("Es un triángulo isósceles.")
                isosceles++
            }
            else -> {
                println("Es un triángulo escaleno.")
                escaleno++
            }
        }
    }

    println("\nResumen:")
    println("Triángulos equiláteros: $equilatero")
    println("Triángulos isósceles: $isosceles")
    println("Triángulos escalenos: $escaleno")
}
