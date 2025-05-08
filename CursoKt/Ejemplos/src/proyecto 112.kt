fun main(){
    val persona1=persona("juan",12)
    persona1.imprimir()
    persona1.esMayorEdad()
}

class persona constructor(nombre:String,edad:Int){
    var nombre:String=nombre
    var edad:Int=edad

    fun imprimir(){ println("nombre :$nombre y tiene $edad años") }

    fun esMayorEdad(){
        if(edad>=18){ println("$nombre es mayor de edad") }
        else{ println("$nombre no es mayor de edad") }
    }
}