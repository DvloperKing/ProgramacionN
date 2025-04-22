fun main(){
    var nidoVacio=0; var hijoUnico=0; var hermanos=0
    for(i in  1..10){
        println("ingrese la cantidad de hijos")
        var hijos= readln().toInt()
        when{
            hijos==0->nidoVacio++
            hijos==1->hijoUnico++
            hijos==2->hermanos++
        }
    }
    println("**********")
    println("hay $nidoVacio familias sin hijos")
    println("hay $hijoUnico familias con un unico hijo")
    println("hay $hermanos familias con 2 hijos")
}