fun main(){
    print("ingrese un numero: ")
    var numero= readLine()!!.toInt()
    when{
        numero>0-> print("el numero es positivo")
        numero==0-> print("el numero es 0")
        numero<0-> print("el numero es negativo")
    }
}