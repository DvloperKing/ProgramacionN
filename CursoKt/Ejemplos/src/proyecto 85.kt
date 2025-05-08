fun main(){
    print("ingrese el valor del lado del cuadrado: ")
    val lado = readln().toInt()
    println("la superficie del cuadrado es ${retornarSuperficie2(lado)}")
}
fun retornarSuperficie2(lado:Int):Int =lado*lado