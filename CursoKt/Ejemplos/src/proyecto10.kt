//Ingresar por teclado un valor entero. Almacenar en otra variable el cuadrado de dicho
//número si el valor ingresado es par, en caso que sea impar guardar el cubo.
//Mostrar además un mensaje que indique si se calcula el cuadrado o el cubo.

fun main(parametro: Array<String>) {
    print("Ingrese un valor entero: ")
    val valor = readLine()!!.toInt()
    val resultado = if (valor % 2 == 0) {
        print("Cuadrado: ")
        valor * valor
    } else {
        print("Cubo: ")
        valor * valor * valor
    }
    print(resultado)
}