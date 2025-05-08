//Ingreso de tres notas y mostrar "Promocionado", "Regular" o "Libre".
fun main(parametros: Array<String>) {
    print("Ingrese primer nota:")
    val nota1 = readLine()!!.toInt()
    print("Ingrese segunda nota:")
    val nota2 = readLine()!!.toInt()
    print("Ingrese tercer nota:")
    val nota3 = readLine()!!.toInt()
    val promedio = (nota1 + nota2 + nota3) / 3
    if (promedio >= 7)
        print("Promocionado")
    else
        if (promedio >= 4)
            print("Regular")
        else
            print("Libre")
}