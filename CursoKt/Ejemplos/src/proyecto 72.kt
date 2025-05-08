fun main(){
    cuadrado()
    println("************")
    multiplicacion()
}

fun cuadrado(){
    println("ingrese un numero")
    var num1= readln().toInt()
    println(num1*num1)
}

fun multiplicacion(){
    println("ingrese un numero")
    var num1= readln().toInt()
    println("ingrese otro numero")
    var num2= readln().toInt()
    println(num1*num2)
}