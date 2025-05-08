fun main(){
    print("Ingrese un valor entero positivo comprendido entre 1 y 99999:")
    val valor = readLine()!!.toInt()
    when (valor){
        in 1..9 -> print("Tiene 1 dígito")
        in 10..99 -> print("Tiene 2 dígitos")
        in 100..999 -> print("Tiene 3 dígitos")
        in 1000..9999 -> print("Tiene 4 dígitos")
        in 10000..99999 -> print("Tiene 5 dígitos")
        else -> print("No se encuentra comprendido en el rango indicado")
    }
}