fun main(){
    print("ingrese el primer valor")
    val valor1= readln().toInt()
    println("ingrese el primer valor")
    val valor2= readln().toInt()
    println("el mayor entre $valor1 y $valor2 es ${retornarMayor2(valor1,valor2)}")
}

fun retornarMayor2(v1:Int,v2:Int)=if (v1>v2) v1 else v2