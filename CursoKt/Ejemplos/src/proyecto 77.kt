fun main(){
    println("ingrese un mensaje")
    var mensaje1= readln()
    println("ingrese otro mensaje")
    var mensaje2= readln()
    sonIguales(mensaje1,mensaje2)
}

fun sonIguales(men1:String,men2:String){
    if(men1==men2){ println("los mensajes son iguales") }
    else{ println("los mensajes no son iguales") }
}