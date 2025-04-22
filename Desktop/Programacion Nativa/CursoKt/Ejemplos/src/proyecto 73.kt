fun main(){
    mayor()
    mayor()
}

fun mayor(){
    println("ingrese 3 numeros")
    var num1= readln().toInt()
    var num2= readln().toInt()
    var num3= readln().toInt()
    if(num1 > num2 && num1 > num3){ println("el mayor es $num1") }
    else if(num2>num3){ println("el mayor es $num2") }
    else{ println("el mayor es $num3") }
}